//BOJ_1012 유기농배추

package BOJ_1000.BOJ_1012;

import java.io.*;
import java.util.*;

public class BOJ_1012 {


    static int arr[][];
    static int testcase_num;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean visited[][];

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }



    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testcase_num = Integer.parseInt(br.readLine());


        for (int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int arr_x = Integer.parseInt(st.nextToken());
            int arr_y = Integer.parseInt(st.nextToken());
            int graph_num = Integer.parseInt(st.nextToken());

            arr = new int[arr_x][arr_y]; // 입력받을 배열
            visited = new boolean[arr_x][arr_y]; //방문 여부 체크

            for(int j = 0; j < graph_num; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            int wormCount = 0;
            for (int x = 0; x < arr_x; x++) {
                for(int y = 0; y < arr_y; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        wormCount++;
                    }
                }
            }
        System.out.println(wormCount);

        }




        
    }
}
