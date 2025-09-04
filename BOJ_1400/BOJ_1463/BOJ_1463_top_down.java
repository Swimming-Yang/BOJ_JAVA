package BOJ_1400.BOJ_1463;

import java.io.*;
import java.util.*;

public class BOJ_1463_top_down {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] dp;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        
        dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recursive(n));
    }

    public static int recursive(int n) {
        if(n == 1 || n == 0) {
            return 0;
        }

        if(dp[n] == 0) {
            if(n % 6 == 0) {
                dp[n] = Math.min(Math.min(recursive(n / 3) + 1, (recursive(n / 2) + 1)), recursive(n - 1) + 1);
            }
            else if(n % 3 == 0) {
                dp[n] = Math.min(recursive(n - 1) + 1, recursive(n / 3) + 1);
            }
            else if(n % 2 == 0) {
                dp[n] = Math.min(recursive(n - 1) + 1, recursive(n / 2) + 1);
            }
            else {
                dp[n] = recursive(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
