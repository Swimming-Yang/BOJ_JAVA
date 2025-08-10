//BOJ_4963 섬의개수 풀이 2

package BOJ_4900.BOJ_4963;

import java.io.*;
import java.util.*;

public class BOJ_4963_1 {

    static boolean [][] visited;
    static int [][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};

    static int w;
    static int h;



    public static void main(String[] args) throws IOException{
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());


            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            //map에 지도 값 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int island_count = 0;

            for(int i = 0; i < h; i++) {
                for(int j = 0 ; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        island_count++;
                    }
                }
            }
            System.out.println(island_count);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }



    }

    }


