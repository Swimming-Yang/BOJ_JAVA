//&BOJ_23258_밤편지
package BOJ_23200;

import java.io.*;
import java.util.*;

public class BOJ_23258 {

    public static int[][][] map;
    public static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        map = new int[Node + 1][Node + 1][Node + 1];
        
        for(int i = 1; i <= Node; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= Node; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if(i == j) {
                    //*자기자신 대각선 */
                    for(int k = 0; k <= Node; k++) {
                        map[i][j][k] = 0;
                    }
                } else {
                    //*연결 */
                    map[i][j][0] = (weight == 0) ? INF : weight;
                }
            }
        }

        //*플로이드 */
        for(int k = 1; k <= Node; k++) {
            for(int i = 1; i <= Node; i++) {
                for(int j = 1; j <= Node; j++) {
                    map[i][j][k] = Math.min(map[i][j][k-1], map[i][k][k-1] + map[k][j][k-1]);
                }
            }
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());  // 이슬 한계
            int s = Integer.parseInt(st.nextToken());  // 출발
            int e = Integer.parseInt(st.nextToken());  // 도착
            
            int idx = C - 1;
            
            if(map[s][e][idx] == INF) {
                sb.append(-1).append('\n');
                // System.out.println(-1);
            } else {
                sb.append(map[s][e][idx]).append('\n');
                // System.out.println(map[s][e][idx]);
            }
        }

        System.out.print(sb);
    }
}