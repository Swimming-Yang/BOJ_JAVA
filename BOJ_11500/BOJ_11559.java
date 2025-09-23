//BOJ_11559 PuyoPuyo
package BOJ_11500;

import java.io.*;
import java.util.*;

public class BOJ_11559 {
    public static char[][] map;
    public static boolean[][] visited;
    public static ArrayList<locate> cur;
    public static int count = 0;
    public static int chainCount = 0;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static class locate {
        int row;
        int col;

        public locate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new char[12][6];
        
        // 필드 정보 입력
        for(int i = 0; i < 12; i++) {
            String line = br.readLine();
            for(int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        // 필드 탐색 - 연쇄가 없을 때까지 반복
        while(true) {
            boolean bomb = false;
            
            // 필드 전체를 탐색
            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    // '.'이면 볼 필요 없으니 패스
                    if(map[i][j] == '.') {
                        continue;
                    } else {
                        // 탐색해서 4개 이상 연결되면 터뜨리기
                        if(search(i, j)) {
                            bomb = true;
                        }
                    }
                }
            }
            
            // 이번 턴에 터진 뿌요가 없으면 게임 종료
            if(!bomb) {
                break;
            }
            
            // 터진 후 중력 적용
            gravity();
            chainCount++;
        }
        
        System.out.println(chainCount);
    }

    public static boolean search(int i, int j) {
        visited = new boolean[12][6];
        cur = new ArrayList<>();
        visited[i][j] = true;
        cur.add(new locate(i, j));
        
        count = 1;
        
        Deque<locate> dq = new ArrayDeque<>();
        dq.offer(new locate(i, j));
        
        while(!dq.isEmpty()) {
            locate cur_loc = dq.poll();
            int cr = cur_loc.row;
            int cc = cur_loc.col;
            
            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 범위 안에 있으며
                if(nr >= 0 && nr < 12 && nc >= 0 && nc < 6) {
                    // 방문하지 않았으며
                    if(!visited[nr][nc]) {
                        // 현재 맵과 같은 알파벳이라면?
                        if(map[cr][cc] == map[nr][nc]) {
                            dq.offer(new locate(nr, nc));
                            visited[nr][nc] = true;
                            cur.add(new locate(nr, nc));
                            count++;
                        }
                    }
                }
            }
        }
        
        // 4개 이상 연결되면 2222터뜨리기
        if(count >= 4) {
            for(int k = 0; k < cur.size(); k++) {
                locate cur_location = cur.get(k);
                int cur_r = cur_location.row;
                int cur_c = cur_location.col;
                map[cur_r][cur_c] = '.';
            }
            return true; // 폭발 o
        }
        return false; // 폭발 x
    }

    // 중력 처리
    public static void gravity() {
        // 각 열에 대해 중력 처리
        for(int col = 0; col < 6; col++) {
            StringBuilder sb = new StringBuilder();
            
            // 해당 열의 모든 뿌요를 StringBuilder에 저장 (아래쪽부터)
            for(int row = 11; row >= 0; row--) { // 아래쪽부터 위쪽으로
                if(map[row][col] != '.') {
                    sb.append(map[row][col]);
                    map[row][col] = '.'; // 기존 위치는 비우기
                }
            }
            
            // StringBuilder에 저장된 뿌요들을 맨 아래부터 다시 배치
            String newline = sb.toString();
            for(int i = 0; i < newline.length(); i++) {
                map[11 - i][col] = newline.charAt(i); // 맨 아래(11행)부터 위로 채우기
            }
        }
    }
}