package BOJ_11400;

import java.io.*;
import java.util.*;

public class BOJ_11403 {

    public static int[][] map;
    public static int INF = 100_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int Node = Integer.parseInt(br.readLine());
        map = new int[Node][Node];        

        for(int row = 0; row < Node; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < Node; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        //*플로이드 - 와샬 */
        for(int mid = 0; mid < Node; mid++) {
            for(int str = 0; str < Node; str++) {
                for(int end = 0; end < Node; end++) {
                    map[str][end] = Math.min(map[str][end], map[str][mid] + map[mid][end]);
                }
            }
        }

        for(int row = 0; row < Node; row++) {
            for(int col = 0; col < Node; col++) {
                if(map[row][col] == 0) {
                    sb.append(0 + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}