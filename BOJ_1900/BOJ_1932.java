package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1932 {
    
    public static int[][] map;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        dp = new int[size][size];

        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());            
            }
        }

        for(int i = 1; i <= size; i++) {
            for(int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + map[i][j], dp[i - 1][j] + map[i][j]);
            }
        }
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++) {
            answer = Math.max(answer, dp[size - 1][i]);
        }

        System.out.println(answer);


        


    }
    
}
