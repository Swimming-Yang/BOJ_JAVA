//&BOJ_1003_피보나치 함수
//cspell:ignore fibo

package BOJ_1000;

import java.io.*;

public class BOJ_1003 {

    public static int[][] fibo = new int[41][2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase_num; i++) {
            int target_num = Integer.parseInt(br.readLine());
            for(int j = 2; j <= target_num; j++) {
                fibo[j][0] = fibo[j - 1][0] + fibo[j - 2][0];
                fibo[j][1] = fibo[j - 1][1] + fibo[j - 2][1];
            }

            System.out.println(fibo[target_num][0] + " " + fibo[target_num][1]);

    }
    }
}



