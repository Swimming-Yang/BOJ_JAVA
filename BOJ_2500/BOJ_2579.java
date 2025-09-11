//&BOJ_2579_계단오르기

package BOJ_2500;

import java.io.*;
import java.util.*;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        
        int[] stair = new int[size + 1];
        for(int i = 1; i <= size; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        
        // dp[i][0]: i번째 계단에 도달, 직전 계단을 밟지 않음
        // dp[i][1]: i번째 계단에 도달, 직전 계단을 밟음
        int[][] dp = new int[size + 1][2];
        
        // 초기값 설정
        dp[1][0] = stair[1]; // 1번째 계단 (직전 계단 없음)
        dp[1][1] = 0;        // 불가능한 경우
        
        for(int i = 2; i <= size; i++) {
            // i번째 계단에 도달하되 직전 계단을 밟지 않은 경우
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i];
            
            // i번째 계단에 도달하되 직전 계단을 밟은 경우  
            dp[i][1] = dp[i-1][0] + stair[i];
        }
        
        // 마지막 계단은 반드시 밟아야 하므로 두 경우 중 최댓값
        System.out.println(Math.max(dp[size][0], dp[size][1]));
    }
}