package SWEA_3200;

import java.io.*;
import java.util.*;

public class SWEA_3282 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testcase_num = Integer.parseInt(br.readLine());
        
        for(int test = 1; test <= testcase_num; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            

            int[] weight = new int[N + 1];
            int[] value = new int[N + 1];
            
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());  // 부피
                value[i] = Integer.parseInt(st.nextToken());   // 가치
            }
            
            int[][] dp = new int[N + 1][K + 1];
            
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= K; j++) {
                    dp[i][j] = dp[i-1][j];
                    
                    if(weight[i] <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i]] + value[i]);
                    }
                }
            }
            System.out.println("#" + test + " " + dp[N][K]);
        }
    }
}