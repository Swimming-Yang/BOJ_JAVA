//*BOJ_1463 1로만들기 
package BOJ_1400.BOJ_1463;

import java.io.*;
import java.util.*;

public class BOJ_1463_bottom_up {

    public static int[] dp;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        dp = new int[num + 1];

        dp[0] = dp[1] = 0;

        for(int i = 2; i <= num; i++) {

            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[num]);

    }

}
