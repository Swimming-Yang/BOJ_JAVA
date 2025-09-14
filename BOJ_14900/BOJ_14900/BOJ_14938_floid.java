package BOJ_14900.BOJ_14900;

import java.io.*;
import java.util.*;

public class BOJ_14938_floid {

    public static int[][] map;
    public static int[] dist;

    public static int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Range = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        map = new int[Node + 1][Node + 1];
        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(i == j) {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = INF;
                }
            }
        }
        

        dist = new int[Node + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= Node; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        //*그래프 간선 연결 */
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start][end] = weight;
            map[end][start] = weight;
        }

        
        for(int mid = 1; mid <= Node; mid++) {
            for(int front = 1; front <= Node; front++) {
                for(int back = 1; back <= Node; back++) {
                    map[front][back] = Math.min(map[front][back], map[front][mid] + map[mid][back]);
                }
            }
        }

        int max_value = 0;
        //*최대 값을 찾는 로직 */
        for(int i = 1; i <= Node; i++) {
            int cur_value = 0;

            for(int j = 1; j <= Node; j++) {
                if(map[i][j] != INF && map[i][j] <= Range) {
                    cur_value += dist[j];
                }
            }
            if(cur_value >= max_value) max_value = cur_value;
        }
        System.out.println(max_value);
    }

    

}
