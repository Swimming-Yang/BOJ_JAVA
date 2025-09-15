package BOJ_14900;

import java.io.*;
import java.util.*;

public class BOJ_14940 {

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int[][] map;
    public static boolean[][] visited;
    public static final int INF = 100_000_001;

    public static class pair {
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
    } 

    public static void bfs(int row, int col) {

        Deque<pair> dq = new ArrayDeque<>();

        dq.offer(new pair(row, col));

        while(!dq.isEmpty()) {
            pair current = dq.poll();
            int cur_row = current.row;
            int cur_col = current.col;

            visited[cur_row][cur_col] = true;

            for(int i = 0; i < 4; i++) {
                int next_row = cur_row + dr[i];
                int next_col = cur_col + dc[i];

                if(!visited[next_row][next_col]) {
                    if(next_row >= 0 && next_row < row && next_col >= 0 && next_col < col) {
                        dq.offer(new pair(next_row, next_col));
                    }
                }
            }
        }
    }
}
