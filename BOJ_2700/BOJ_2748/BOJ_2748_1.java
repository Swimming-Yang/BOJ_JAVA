//BOJ_2748 피보나치 수2_Dp

package BOJ_2748;

import java.io.*;

public class BOJ_2748_1 {

    static long[] fibo_arr;
    static int testcase_num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testcase_num = Integer.parseInt(br.readLine());
        fibo_arr = new long[91];
        fibo_arr[0] = 0L;
        fibo_arr[1] = 1L;

        for(int i = 2; i <= testcase_num; i++) {
            fibo_arr[i] = fibo_arr[i - 1] + fibo_arr[i - 2];
        }

        System.out.println(fibo_arr[testcase_num]);
    }
}



