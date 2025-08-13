import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

// 메인 클래스
public class ChessGame extends JFrame {
    private ChessBoard board;
    private JPanel boardPanel;
    private boolean isWhiteTurn = true;
    private JLabel statusLabel;
    private Position selectedPosition = null;
    private boolean gameEnded = false;
    private ChessAI ai;
    private boolean isAIMode = false;
    private JButton aiToggleButton;
    
    public ChessGame() {
        initializeGame();
        createUI();
    }
    
    private void initializeGame() {
        board = new ChessBoard();
        board.setupInitialBoard();
        ai = new ChessAI(board);
    }
    
    private void createUI() {
        setTitle("체스 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // 한글 폰트 설정을 위한 시스템 기본 폰트 확인
        Font koreanFont = getKoreanFont();
        
        // 상태 표시 라벨
        statusLabel = new JLabel("흰색 차례", JLabel.CENTER);
        statusLabel.setFont(koreanFont.deriveFont(Font.BOLD, 16f));
        add(statusLabel, BorderLayout.NORTH);
        
        // 체스판 패널
        boardPanel = new JPanel(new GridLayout(8, 8));
        createBoardUI();
        add(boardPanel, BorderLayout.CENTER);
        
        // 리셋 버튼과 AI 토글 버튼을 담을 패널
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton resetButton = new JButton("새 게임");
        resetButton.setFont(koreanFont.deriveFont(Font.PLAIN, 14f));
        resetButton.addActionListener(e -> resetGame());
        
        aiToggleButton = new JButton("AI 모드 ON");
        aiToggleButton.setFont(koreanFont.deriveFont(Font.PLAIN, 14f));
        aiToggleButton.addActionListener(e -> toggleAIMode());
        
        buttonPanel.add(resetButton);
        buttonPanel.add(aiToggleButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setSize(600, 650);
        setLocationRelativeTo(null);
    }
    
    private Font getKoreanFont() {
        // 한글 지원 폰트들을 순서대로 시도
        String[] fontNames = {
            "맑은 고딕", "Malgun Gothic", 
            "굴림", "Gulim",
            "돋움", "Dotum",
            "바탕", "Batang",
            "Dialog", "SansSerif"
        };
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] availableFonts = ge.getAvailableFontFamilyNames();
        
        for (String fontName : fontNames) {
            for (String availableFont : availableFonts) {
                if (availableFont.equals(fontName)) {
                    return new Font(fontName, Font.PLAIN, 12);
                }
            }
        }
        
        // 기본 폰트 반환
        return new Font("Dialog", Font.PLAIN, 12);
    }
    
    private void createBoardUI() {
        boardPanel.removeAll();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessSquare square = new ChessSquare(row, col, board.getPiece(row, col));
                square.addActionListener(new SquareClickListener(row, col));
                boardPanel.add(square);
            }
        }
        boardPanel.revalidate();
        boardPanel.repaint();
    }
    
    private class SquareClickListener implements ActionListener {
        private int row, col;
        
        public SquareClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameEnded) return; // 게임이 끝났으면 클릭 무시
            
            // AI 모드에서 흑색 턴이면 클릭 무시
            if (isAIMode && !isWhiteTurn) return;
            
            Position clickedPos = new Position(row, col);
            
            if (selectedPosition == null) {
                // 첫 번째 클릭 - 말 선택
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.isWhite() == isWhiteTurn) {
                    selectedPosition = clickedPos;
                    highlightPossibleMoves(clickedPos);
                }
            } else {
                // 두 번째 클릭 - 이동 시도
                if (selectedPosition.equals(clickedPos)) {
                    // 같은 위치 클릭 - 선택 해제
                    selectedPosition = null;
                    createBoardUI();
                } else {
                    // 이동 시도
                    attemptMove(selectedPosition, clickedPos);
                }
            }
        }
    }
    
    private void highlightPossibleMoves(Position pos) {
        createBoardUI();
        List<Position> possibleMoves = board.getPossibleMoves(pos);
        
        // 선택된 말 하이라이트
        ChessSquare selectedSquare = (ChessSquare) boardPanel.getComponent(pos.row * 8 + pos.col);
        selectedSquare.setSelected(true);
        
        // 가능한 이동 위치 하이라이트
        for (Position move : possibleMoves) {
            ChessSquare square = (ChessSquare) boardPanel.getComponent(move.row * 8 + move.col);
            square.setPossibleMove(true);
        }
    }
    
    private void attemptMove(Position from, Position to) {
        if (board.isValidMove(from, to, isWhiteTurn)) {
            // 킹이 잡히는지 확인
            Piece capturedPiece = board.getPiece(to.row, to.col);
            boolean kingCaptured = capturedPiece instanceof King;
            
            board.movePiece(from, to);
            isWhiteTurn = !isWhiteTurn;
            selectedPosition = null;
            createBoardUI();
            
            // 킹이 잡혔으면 게임 종료
            if (kingCaptured) {
                String winner = capturedPiece.isWhite() ? "흑색" : "흰색";
                statusLabel.setText(winner + " 승리! (킹이 잡혔습니다!)");
                statusLabel.setFont(getKoreanFont().deriveFont(Font.BOLD, 16f));
                disableBoard();
            } else {
                updateStatus();
                
                // AI 모드이고 흑색 차례면 AI 이동
                if (isAIMode && !isWhiteTurn && !gameEnded) {
                    makeAIMove();
                }
            }
        } else {
            selectedPosition = null;
            createBoardUI();
        }
    }
    
    private void disableBoard() {
        gameEnded = true;
        // 모든 버튼 비활성화
        for (Component comp : boardPanel.getComponents()) {
            comp.setEnabled(false);
        }
    }
    
    private void updateStatus() {
        Font koreanFont = getKoreanFont();
        if (board.isCheckmate(!isWhiteTurn)) {
            statusLabel.setText((isWhiteTurn ? "흑색" : "흰색") + " 승리! (체크메이트)");
        } else if (board.isCheck(!isWhiteTurn)) {
            statusLabel.setText((isWhiteTurn ? "흰색" : "흑색") + " 차례 (체크!)");
        } else {
            statusLabel.setText((isWhiteTurn ? "흰색" : "흑색") + " 차례");
        }
        statusLabel.setFont(koreanFont.deriveFont(Font.BOLD, 16f));
    }
    
    private void toggleAIMode() {
        isAIMode = !isAIMode;
        Font koreanFont = getKoreanFont();
        
        if (isAIMode) {
            aiToggleButton.setText("AI 모드 OFF");
            statusLabel.setText("AI 모드: 당신은 흰색입니다");
            // 현재 흑색 차례이고 게임이 진행 중이면 AI 이동
            if (!isWhiteTurn && !gameEnded) {
                makeAIMove();
            }
        } else {
            aiToggleButton.setText("AI 모드 ON");
            updateStatus();
        }
        
        aiToggleButton.setFont(koreanFont.deriveFont(Font.PLAIN, 14f));
    }
    
    private void makeAIMove() {
        // AI 이동을 백그라운드에서 처리 (UI 블로킹 방지)
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            Move aiMove = ai.getBestMove(isWhiteTurn);
            if (aiMove != null) {
                board.movePiece(aiMove.from, aiMove.to);
                isWhiteTurn = !isWhiteTurn;
                createBoardUI();
                
                // 킹이 잡혔는지 확인
                if (aiMove.capturedPiece instanceof King) {
                    String winner = aiMove.capturedPiece.isWhite() ? "흑색" : "흰색";
                    statusLabel.setText(winner + " (AI) 승리! (킹이 잡혔습니다!)");
                    statusLabel.setFont(getKoreanFont().deriveFont(Font.BOLD, 16f));
                    disableBoard();
                } else {
                    updateStatus();
                }
            }
            ((javax.swing.Timer)e.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void resetGame() {
        initializeGame();
        isWhiteTurn = true;
        selectedPosition = null;
        gameEnded = false;
        createBoardUI();
        
        Font koreanFont = getKoreanFont();
        if (isAIMode) {
            statusLabel.setText("AI 모드: 당신은 흰색입니다");
        } else {
            statusLabel.setText("흰색 차례");
        }
        statusLabel.setFont(koreanFont.deriveFont(Font.BOLD, 16f));
        
        // 모든 버튼 다시 활성화
        for (Component comp : boardPanel.getComponents()) {
            comp.setEnabled(true);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChessGame().setVisible(true);
        });
    }
}

// 체스 사각형 UI 컴포넌트
class ChessSquare extends JButton {
    private int row, col;
    private Piece piece;
    
    public ChessSquare(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
        setupSquare();
    }
    
    private void setupSquare() {
        setPreferredSize(new Dimension(70, 70));
        setFont(new Font("Arial Unicode MS", Font.BOLD, 36));
        
        // 체스판 색칠
        if ((row + col) % 2 == 0) {
            setBackground(Color.WHITE);
        } else {
            setBackground(new Color(139, 69, 19));
        }
        
        // 말 표시
        if (piece != null) {
            setText(piece.getSymbol());
            setForeground(piece.isWhite() ? Color.BLACK : Color.BLUE);
        } else {
            setText("");
        }
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
    
    public void setSelected(boolean selected) {
        if (selected) {
            setBackground(Color.YELLOW);
        } else {
            setupSquare();
        }
    }
    
    public void setPossibleMove(boolean possibleMove) {
        if (possibleMove) {
            setBackground(Color.GREEN);
        }
    }
}

// 위치 클래스
class Position {
    int row, col;
    
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position other = (Position) obj;
            return row == other.row && col == other.col;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return row * 8 + col;
    }
    
    public boolean isValid() {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}

// 체스 보드 클래스
class ChessBoard {
    private Piece[][] board = new Piece[8][8];
    
    public void setupInitialBoard() {
        // 흰색 말들 (아래쪽)
        board[7][0] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
        board[7][5] = new Bishop(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rook(true);
        
        for (int col = 0; col < 8; col++) {
            board[6][col] = new Pawn(true);
        }
        
        // 검은색 말들 (위쪽)
        board[0][0] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false);
        board[0][5] = new Bishop(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rook(false);
        
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(false);
        }
    }
    
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }
    
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }
    
    public boolean movePiece(Position from, Position to) {
        Piece piece = board[from.row][from.col];
        board[to.row][to.col] = piece;
        board[from.row][from.col] = null;
        return true;
    }
    
    public List<Position> getPossibleMoves(Position pos) {
        Piece piece = board[pos.row][pos.col];
        if (piece == null) return new ArrayList<>();
        
        return piece.getPossibleMoves(pos, this);
    }
    
    public boolean isValidMove(Position from, Position to, boolean isWhiteTurn) {
        Piece piece = board[from.row][from.col];
        if (piece == null || piece.isWhite() != isWhiteTurn) {
            return false;
        }
        
        List<Position> possibleMoves = piece.getPossibleMoves(from, this);
        return possibleMoves.contains(to);
    }
    
    public boolean isCheck(boolean isWhiteKing) {
        Position kingPos = findKing(isWhiteKing);
        if (kingPos == null) return false;
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.isWhite() != isWhiteKing) {
                    List<Position> moves = piece.getPossibleMoves(new Position(row, col), this);
                    if (moves.contains(kingPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isCheckmate(boolean isWhiteKing) {
        if (!isCheck(isWhiteKing)) return false;
        
        // 체크 상태에서 벗어날 수 있는 이동이 있는지 확인
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.isWhite() == isWhiteKing) {
                    List<Position> moves = piece.getPossibleMoves(new Position(row, col), this);
                    for (Position move : moves) {
                        // 임시 이동
                        Piece temp = board[move.row][move.col];
                        board[move.row][move.col] = piece;
                        board[row][col] = null;
                        
                        boolean stillInCheck = isCheck(isWhiteKing);
                        
                        // 이동 되돌리기
                        board[row][col] = piece;
                        board[move.row][move.col] = temp;
                        
                        if (!stillInCheck) {
                            return false; // 체크에서 벗어날 수 있음
                        }
                    }
                }
            }
        }
        return true; // 체크메이트
    }
    
    private Position findKing(boolean isWhite) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece instanceof King && piece.isWhite() == isWhite) {
                    return new Position(row, col);
                }
            }
        }
        return null;
    }
}

// 말의 기본 클래스
abstract class Piece {
    protected boolean isWhite;
    
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }
    
    public boolean isWhite() {
        return isWhite;
    }
    
    public abstract String getSymbol();
    public abstract List<Position> getPossibleMoves(Position currentPos, ChessBoard board);
    
    protected boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
    
    protected boolean canMoveTo(Position pos, ChessBoard board) {
        if (!pos.isValid()) return false;
        Piece targetPiece = board.getPiece(pos.row, pos.col);
        return targetPiece == null || targetPiece.isWhite() != this.isWhite;
    }
}

// 킹
class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♔" : "♚";
    }
    
    @Override
    public List<Position> getPossibleMoves(Position currentPos, ChessBoard board) {
        List<Position> moves = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 8; i++) {
            Position newPos = new Position(currentPos.row + dx[i], currentPos.col + dy[i]);
            if (canMoveTo(newPos, board)) {
                moves.add(newPos);
            }
        }
        return moves;
    }
}

// 퀸
class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♕" : "♛";
    }
    
    @Override
    public List<Position> getPossibleMoves(Position currentPos, ChessBoard board) {
        List<Position> moves = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 8; i++) {
            for (int step = 1; step < 8; step++) {
                Position newPos = new Position(currentPos.row + dx[i] * step, 
                                             currentPos.col + dy[i] * step);
                if (!newPos.isValid()) break;
                
                Piece targetPiece = board.getPiece(newPos.row, newPos.col);
                if (targetPiece == null) {
                    moves.add(newPos);
                } else {
                    if (targetPiece.isWhite() != this.isWhite) {
                        moves.add(newPos);
                    }
                    break;
                }
            }
        }
        return moves;
    }
}

// 룩 (전차)
class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♖" : "♜";
    }
    
    @Override
    public List<Position> getPossibleMoves(Position currentPos, ChessBoard board) {
        List<Position> moves = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            for (int step = 1; step < 8; step++) {
                Position newPos = new Position(currentPos.row + dx[i] * step, 
                                             currentPos.col + dy[i] * step);
                if (!newPos.isValid()) break;
                
                Piece targetPiece = board.getPiece(newPos.row, newPos.col);
                if (targetPiece == null) {
                    moves.add(newPos);
                } else {
                    if (targetPiece.isWhite() != this.isWhite) {
                        moves.add(newPos);
                    }
                    break;
                }
            }
        }
        return moves;
    }
}

// 비숍 (주교)
class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♗" : "♝";
    }
    
    @Override
    public List<Position> getPossibleMoves(Position currentPos, ChessBoard board) {
        List<Position> moves = new ArrayList<>();
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            for (int step = 1; step < 8; step++) {
                Position newPos = new Position(currentPos.row + dx[i] * step, 
                                             currentPos.col + dy[i] * step);
                if (!newPos.isValid()) break;
                
                Piece targetPiece = board.getPiece(newPos.row, newPos.col);
                if (targetPiece == null) {
                    moves.add(newPos);
                } else {
                    if (targetPiece.isWhite() != this.isWhite) {
                        moves.add(newPos);
                    }
                    break;
                }
            }
        }
        return moves;
    }
}

// 나이트 (기사)
class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♘" : "♞";
    }
    
    @Override
    public List<Position> getPossibleMoves(Position currentPos, ChessBoard board) {
        List<Position> moves = new ArrayList<>();
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        
        for (int i = 0; i < 8; i++) {
            Position newPos = new Position(currentPos.row + dx[i], currentPos.col + dy[i]);
            if (canMoveTo(newPos, board)) {
                moves.add(newPos);
            }
        }
        return moves;
    }
}

// 폰
class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public String getSymbol() {
        return isWhite ? "♙" : "♟";
    }
    
    @Override
    public List<Position> getPossibleMoves(Position currentPos, ChessBoard board) {
        List<Position> moves = new ArrayList<>();
        int direction = isWhite ? -1 : 1;
        
        // 앞으로 한 칸
        Position oneStep = new Position(currentPos.row + direction, currentPos.col);
        if (oneStep.isValid() && board.getPiece(oneStep.row, oneStep.col) == null) {
            moves.add(oneStep);
            
            // 초기 위치에서 두 칸
            int startRow = isWhite ? 6 : 1;
            if (currentPos.row == startRow) {
                Position twoStep = new Position(currentPos.row + direction * 2, currentPos.col);
                if (twoStep.isValid() && board.getPiece(twoStep.row, twoStep.col) == null) {
                    moves.add(twoStep);
                }
            }
        }
        
        // 대각선 공격
        Position leftAttack = new Position(currentPos.row + direction, currentPos.col - 1);
        if (leftAttack.isValid()) {
            Piece target = board.getPiece(leftAttack.row, leftAttack.col);
            if (target != null && target.isWhite() != this.isWhite) {
                moves.add(leftAttack);
            }
        }
        
        Position rightAttack = new Position(currentPos.row + direction, currentPos.col + 1);
        if (rightAttack.isValid()) {
            Piece target = board.getPiece(rightAttack.row, rightAttack.col);
            if (target != null && target.isWhite() != this.isWhite) {
                moves.add(rightAttack);
            }
        }
        
        return moves;
    }
}

// AI 이동을 나타내는 클래스
class Move {
    Position from, to;
    Piece capturedPiece;
    int score;
    
    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }
    
    public Move(Position from, Position to, Piece capturedPiece) {
        this.from = from;
        this.to = to;
        this.capturedPiece = capturedPiece;
    }
}

// 체스 AI 클래스
class ChessAI {
    private ChessBoard board;
    private Random random;
    
    // 말의 가치
    private static final Map<Class<? extends Piece>, Integer> PIECE_VALUES = new HashMap<>();
    static {
        PIECE_VALUES.put(Pawn.class, 1);
        PIECE_VALUES.put(Knight.class, 3);
        PIECE_VALUES.put(Bishop.class, 3);
        PIECE_VALUES.put(Rook.class, 5);
        PIECE_VALUES.put(Queen.class, 9);
        PIECE_VALUES.put(King.class, 100);
    }
    
    public ChessAI(ChessBoard board) {
        this.board = board;
        this.random = new Random();
    }
    
    public Move getBestMove(boolean isWhite) {
        List<Move> allMoves = getAllPossibleMoves(isWhite);
        if (allMoves.isEmpty()) return null;
        
        // 1. 킹을 잡을 수 있는 이동이 있으면 우선
        for (Move move : allMoves) {
            Piece target = board.getPiece(move.to.row, move.to.col);
            if (target instanceof King) {
                move.capturedPiece = target;
                return move;
            }
        }
        
        // 2. 각 이동의 점수 계산
        Move bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        
        for (Move move : allMoves) {
            int score = evaluateMove(move, isWhite);
            
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            } else if (score == bestScore && random.nextDouble() < 0.3) {
                // 같은 점수면 30% 확률로 바꿔서 다양성 추가
                bestMove = move;
            }
        }
        
        if (bestMove != null) {
            bestMove.capturedPiece = board.getPiece(bestMove.to.row, bestMove.to.col);
        }
        
        return bestMove;
    }
    
    private List<Move> getAllPossibleMoves(boolean isWhite) {
        List<Move> moves = new ArrayList<>();
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.isWhite() == isWhite) {
                    Position from = new Position(row, col);
                    List<Position> possibleMoves = piece.getPossibleMoves(from, board);
                    
                    for (Position to : possibleMoves) {
                        moves.add(new Move(from, to));
                    }
                }
            }
        }
        
        return moves;
    }
    
    private int evaluateMove(Move move, boolean isWhite) {
        int score = 0;
        
        // 1. 상대방 말을 잡는 점수
        Piece capturedPiece = board.getPiece(move.to.row, move.to.col);
        if (capturedPiece != null) {
            score += PIECE_VALUES.get(capturedPiece.getClass()) * 10;
        }
        
        // 2. 중앙으로 이동하는 점수
        double centerDistance = Math.abs(move.to.row - 3.5) + Math.abs(move.to.col - 3.5);
        score += (int)(7 - centerDistance);
        
        // 3. 공격받는 위치로 이동하는 페널티
        if (isUnderAttack(move.to, !isWhite)) {
            Piece movingPiece = board.getPiece(move.from.row, move.from.col);
            score -= PIECE_VALUES.get(movingPiece.getClass()) * 5;
        }
        
        // 4. 상대 킹을 체크하는 보너스
        if (wouldGiveCheck(move, isWhite)) {
            score += 15;
        }
        
        // 5. 랜덤 요소 추가 (같은 점수의 이동들 중 선택을 위해)
        score += random.nextInt(3);
        
        return score;
    }
    
    private boolean isUnderAttack(Position pos, boolean byWhite) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.isWhite() == byWhite) {
                    List<Position> attacks = piece.getPossibleMoves(new Position(row, col), board);
                    if (attacks.contains(pos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean wouldGiveCheck(Move move, boolean isWhite) {
        // 임시로 이동해보고 체크인지 확인
        Piece originalPiece = board.getPiece(move.to.row, move.to.col);
        Piece movingPiece = board.getPiece(move.from.row, move.from.col);
        
        // 임시 이동
        board.setPiece(move.to.row, move.to.col, movingPiece);
        board.setPiece(move.from.row, move.from.col, null);
        
        boolean givesCheck = board.isCheck(!isWhite);
        
        // 원래대로 되돌리기
        board.setPiece(move.from.row, move.from.col, movingPiece);
        board.setPiece(move.to.row, move.to.col, originalPiece);
        
        return givesCheck;
    }
}