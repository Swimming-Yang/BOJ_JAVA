//BOJ_4963_섬의 개수

package BOJ_4900;

import java.io.*;
import java.util.*;

public class BOJ_4963 {

    static boolean visited[][];


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean roof = true;
        while(roof) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //열
            int b = Integer.parseInt(st.nextToken()); //행
            int count = 0;

            if (a == 0 && b == 0) 
            break;           //종료 조건
            else {
                int [][] arr = new int[b][a];
                visited = new boolean[b][a];

                //배열에 값 넣기
                for(int i = 0; i < b; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < a; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                        }
                    }

                for(int i = 0; i < b; i++) {
                    for(int j = 0; j < a; j++) {
                        if (arr[i][j] == 1 && !visited[i][j]) {
                            bfs(i, j, arr, visited, b, a);
                            count++;
                        }
                    }
                }
                }
                System.out.println(count);
            }
            
        }
        
    static void bfs(int x, int y, int[][] map, boolean[][] visited, int h, int w) {


        //8방탐색
        int [] dx = {0, 1, 1, 1, 0 , -1, -1, -1};
        int [] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];


            //현재좌표 + 팔방탐색 좌표로 다음좌표
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];


                //다음 좌표 범위 체크
                if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }    
            }
        }
    }
}
