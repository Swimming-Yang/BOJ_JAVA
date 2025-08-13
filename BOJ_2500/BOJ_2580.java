//BOJ_2580_스도쿠
import java.io.*;
import java.util.*;

public class BOJ_2580 {
    
    public static StringTokenizer st;
    public static StringBuilder sb;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] map = new int[9][9];
    
    public static void main(String[] args) throws IOException{
        //배열에 기본 값 채우기
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        num_selector(0, 0); // 추가: 스도쿠 해결 시작
    }
    
    public static void num_selector(int row, int col) {
        if (col == 9) {
            num_selector(row + 1, 0);
            return;
        }
        
        if(row == 9) {
            sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        if(map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    map[row][col] = i; // arr → map으로 수정
                    num_selector(row, col + 1); // 매개변수 수정
                    map[row][col] = 0; // 백트래킹 추가
                }
            }
        } else {
            num_selector(row, col + 1); // 이미 채워진 칸은 다음으로
        }
    }
    
    // possibility 함수 추가
    public static boolean possibility(int row, int col, int num) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num) {
                return false;
            }
        }
        
        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == num) {
                return false;
            }
        }
        
        // 3x3 박스 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}