//&BOJ_2458_키순서

package BOJ_2400.BOJ_2458;

import java.io.*;
import java.util.*;

public class BOJ_2458 {

    public static int[][] map;
    public static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());
        int answer = 0;

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
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;

        }

        for(int mid = 1; mid <= Node; mid++) {
            for(int str = 1; str <= Node; str++) {
                for(int ed = 1; ed <= Node; ed++) {
                    map[str][ed] = Math.min(map[str][ed], map[str][mid] + map[mid][ed]);
                }
            }
        }

        for(int i = 1; i <= Node; i++) {
            int count = 0;
            for(int j = 1; j <= Node; j++) {
                if(i != j) {
                    if(map[i][j] != INF || map [j][i] != INF) {
                        count+= 1;
                    }   
                }
            }
            if(count == Node - 1) {
                answer +=1;
            }
        }
        System.out.println(answer);
    }

}
