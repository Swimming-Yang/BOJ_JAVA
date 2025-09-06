package BOJ_15900;

import java.io.*;

public class BOJ_15989 {
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp = new int[10001][4];
        
        dp[0][1] = 1;
        dp[0][2] = 1; 
        dp[0][3] = 1;
        
        // 바텀업 계산
        for(int i = 1; i <= 10000; i++) {
            dp[i][1] = 1;
            
            dp[i][2] = dp[i][1]; // 1만 사용하는 경우
            if(i >= 2) {
                dp[i][2] += dp[i-2][2]; // 마지막에 2를 추가하는 경우 누적
            }
            
            dp[i][3] = dp[i][2]; // 1,2만 사용하는 경우
            if(i >= 3) {
                dp[i][3] += dp[i-3][3]; // 마지막에 3을 추가하는 경우 누적
            }
        }
        
        int testcase_num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testcase_num; i++) {
            int target = Integer.parseInt(br.readLine());
            System.out.println(dp[target][3]);
        }
    }
}