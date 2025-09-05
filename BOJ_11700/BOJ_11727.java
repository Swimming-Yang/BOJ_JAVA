//& BOJ_11727_2XN타일링2

package BOJ_11700;

import java.io.*;

public class BOJ_11727 {
    public static int[] dp = new int[1002];
    public static void main(String[] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 3;
        
        int target = Integer.parseInt(br.readLine());
        for(int i = 3; i <= target; i++) {
            dp[i] = (dp[i - 1] +  dp[i - 2] * 2) % 10007;
        }

        sb.append(dp[target] % 10007);
        System.out.println(sb);
    }

}
