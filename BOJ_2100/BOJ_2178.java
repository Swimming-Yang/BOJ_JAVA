//BOJ_2178_미로찾기

package BOJ_2100;

import java.io.*;
import java.util.*;

public class BOJ_2178 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int[][] graph;
    public static boolean[][] visited;

    public static int rows, cols;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        graph = new int[rows][cols];
        visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            String line = br.readLine();
            for(int j = 0; j < cols; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }


        bfs(0, 0, 1);
    }

    public static void bfs(int x, int y, int distance) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, distance});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int cur[] = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int cur_d = cur[2];

            if(cur_x == rows-1 && cur_y == cols-1) {
            System.out.println(cur_d);
            return;
}


            //사방탐색
            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                int nd = cur_d + 1;

                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if(!visited[nx][ny] && graph[nx][ny] == 1) {
                        q.offer(new int[]{nx, ny, nd});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
    }

}
