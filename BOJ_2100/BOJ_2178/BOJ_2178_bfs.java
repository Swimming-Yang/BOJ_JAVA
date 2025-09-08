package BOJ_2100.BOJ_2178;

import java.io.*;
import java.util.*;

public class BOJ_2178_bfs {

    public static int[][] map;
    public static boolean[][] visited;

    //상 우 하 좌
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int answer = 0;
    public static int row, col;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];

        //*지도 값 입력 */
        for(int i = 1; i <= row; i++) {
            String line = br.readLine();
            for(int j = 1; j <= col; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        int answer = bfs(1, 1, row, col);
        System.out.println(answer);
    }

    public static int bfs(int start_r, int start_c, int end_r, int end_c) {
        Deque<int[]> dq = new ArrayDeque<>();

        visited[start_r][start_c] = true;
        dq.offer(new int[]{start_r, start_c, 1});

        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int cur_r = current[0];
            int cur_c = current[1];
            int cur_d = current[2];

            if(cur_r == end_r && cur_c == end_c) {
                return cur_d;
            }

            for(int i = 0; i < 4; i++) {
                int nr = cur_r + dr[i];
                int nc = cur_c + dc[i];

                if(nr >= 1 && nr <= row && nc >= 1 && nc <= col) {
                    if(!visited[nr][nc] && map[nr][nc] == 1) {
                        dq.offer(new int[]{nr, nc, cur_d + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}


