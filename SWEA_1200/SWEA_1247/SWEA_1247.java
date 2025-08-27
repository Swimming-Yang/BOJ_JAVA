//SWEA_1247_최적경로
//cspell:ignore SWEA

package SWEA_1200.SWEA_1247;

import java.io.*;
import java.util.*;

public class SWEA_1247 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean[] visited;
    public static int[] sel;
    public static int[][] graph;
    public static int[][] customers;

    public static int N; // 고객의 수
    public static int cx;
    public static int cy;
    public static int hx;
    public static int hy;
    public static int minDistance;




    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= testcase_num; i++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());

            customers = new int[N][2];
            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                customers[j][0] = Integer.parseInt(st.nextToken());
                customers[j][1] = Integer.parseInt(st.nextToken());
            }

        dfs(0, cx, cy, 0);
        System.out.println("#" + i + " " + minDistance);
        }

        }

    public static void dfs(int depth, int cur_x, int cur_y, int cur_dist) {
        if(depth == N) {
        int totalDist = cur_dist + Math.abs(cur_x - hx) + Math.abs(cur_y - hy);
        minDistance = Math.min(minDistance, totalDist);
        return;
    }
        for(int i = 0; i < N; i++) {
        if(!visited[i]) {
            visited[i] = true;
            int dist = Math.abs(cur_x - customers[i][0]) + Math.abs(cur_y - customers[i][1]);
            dfs(depth + 1, customers[i][0], customers[i][1], cur_dist + dist);
            visited[i] = false;
        }
    }
    }



}
