package BOJ_11400;

import java.io.*;
import java.util.*;

public class BOJ_11404 {

    public static int[][] map;
    public static int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //*도시(노드)의 개수 */
        int Node = Integer.parseInt(br.readLine());
        map = new int[Node + 1][Node + 1];

        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(i == j) {
                    map[i][j] = 0;
                }
                else map[i][j] = INF;
            }
        }
        //*버스(간선)의 개수 */
        int Edge = Integer.parseInt(br.readLine());

        for(int i = 1; i <= Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            //*까먹음 */
            map[start][end] = Math.min(map[start][end], weight);
        }


        for(int k = 1; k <= Node; k++) { 
            for(int i = 1; i <= Node; i++) {
                for(int j = 1; j <= Node; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        //*출력*/

        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(map[i][j] == INF) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

}
