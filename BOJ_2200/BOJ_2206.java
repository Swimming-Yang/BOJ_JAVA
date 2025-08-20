package BOJ_2200;

import java.io.*;
import java.util.*;

public class BOJ_2206 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int[][] graph;
    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
        
        st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        graph = new int[rows][cols];
        visited = new boolean[rows][cols][2];

        for(int i =0 ; i < rows; i++) {
            String line = br.readLine();
            for(int j = 0; j < cols; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1, 0}); //x좌표, y좌표, 거리, 벽파괴 여부
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int cur_node[] = q.poll();
            int cur_x = cur_node[0];
            int cur_y = cur_node[1];
            int cur_d = cur_node[2];
            int cur_b = cur_node[3];

            if(cur_x == rows -1 && cur_y == cols -1) {
                System.out.println(cur_d);
                return;
            }
        }
    }

}
