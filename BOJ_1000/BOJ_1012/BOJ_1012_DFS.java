package BOJ_1000.BOJ_1012;

import java.io.*;
import java.util.*;

public class BOJ_1012_DFS {
    
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dc = {-1, 0, 1, 0};
    public static int[] dr = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int bechu = Integer.parseInt(st.nextToken());

            map = new int[row][col];
            visited = new boolean[row][col];
            int count = 0;

            for(int j = 0; j < bechu; j++) {
                st = new StringTokenizer(br.readLine());
                int cols = Integer.parseInt(st.nextToken());
                int rows = Integer.parseInt(st.nextToken());
                map[rows][cols] = 1;
            }

            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k, row, col);
                        count += 1;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int cr, int cc, int row, int col) {
        visited[cr][cc] = true;

        for(int i = 0 ; i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];

            if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                if(!visited[nr][nc] && map[nr][nc] == 1) {
                    dfs(nr, nc, row, col);
                }
            }
        }
        
    }

}
