package BOJ_12800;

import java.io.*;
import java.util.*;

public class BOJ_12865 {

    public static int[][] items;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Weight = Integer.parseInt(st.nextToken());
        int Value = Integer.parseInt(st.nextToken());

        items = new int[Weight + 1][2];
        dp = new int[Weight + 1][Value + 1];

        for(int i = 1; i <= Weight; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= Weight; i++) {
            for(int j = 1; j <= Value; j++) {
                if(items[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                }
            }
        }
        System.out.println(dp[Weight][Value]);

    }
}