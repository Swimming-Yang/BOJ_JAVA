package BOJ_1600;

import java.io.*;
import java.util.*;

public class BOJ_1613 {

    public static int[][] map;
    public static int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //*첫 줄에 사건의 개수 N과 알고있는 사건의 전후 관계의 개수 K 가 주어진다 */
        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());

        map = new int[Node + 1][Node + 1];

        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(i == j) {
                    map[i][j] = 0;
                }
                map[i][j] = INF;
            }
        }

        int Edge = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], 1);
        }

        for(int k = 1; k <= Node; k++) {
            for(int i = 1; i <= Node; i++) {
                for(int j = 1; j <= Node; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            if(map[str][ed] == INF && map[ed][str] == INF) {
                System.out.println(0);
            }
            else if(map[str][ed] != INF && map[ed][str] == INF) {
                System.out.println(-1);
            }
            else {
                System.out.println(1);
            }
        }
    }
}
