package BOJ_11400;

import java.io.*;
import java.util.*;

public class BOJ_11403 {

    public static int[][] map;
    
    public static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int Node = Integer.parseInt(br.readLine());
        map = new int[Node][Node];

        for(int i = 0; i < Node; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < Node; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0) map[i][j] = INF;
                else {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        

        for(int mid = 0; mid < Node; mid++){
            for(int str = 0; str < Node; str++) {
                for(int end = 0; end < Node; end++) {
                    map[str][end] = Math.min(map[str][end], map[str][mid] + map[mid][end]);
                }
            }
        }

        for(int i = 0; i < Node; i++) {
            for(int j = 0; j < Node; j++) {
                if(map[i][j] == 0) {
                    sb.append(0 + " ");
                }
                else {
                    sb.append(1 + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}