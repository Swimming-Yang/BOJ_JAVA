/*
 * 2차원 격자 기반 BFS(최단거리, 영역 탐색)
 */

package AlGO.완전탐색.BFS;

import java.io.*;
import java.util.*;

public class BFS_2 {
    
    public static int[][] map;
    public static boolean[][]visited;
    public static int[][] distance;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int rows, cols;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        //배열 초기화
        map = new int[rows][cols];
        visited = new boolean[rows][cols];
        distance = new int[rows][cols];

        for (int i =0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < cols; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //bfs 실행
        bfs(0, 0); 
    }


    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true; //방문 배열 처리
        System.out.println("방문" + x + ", " + y);
        distance[x][y] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cur_x = current[0];
            int cur_y = current[1];

            //사방탐색
            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols) { //nx, ny가 범위안에 있고
                    if (!visited[nx][ny] && map[nx][ny] == 1) { //아직 nx, ny를 방문하지 않았고, 연결되어 있다면
                        visited[nx][ny] = true; //방문처리
                        distance[nx][ny] = distance[cur_x][cur_y] + 1;
                        q.offer(new int[]{nx, ny});
                        System.out.println("방문" + x + ", " + y);
                    }
                }
            }
        }
    }

}
