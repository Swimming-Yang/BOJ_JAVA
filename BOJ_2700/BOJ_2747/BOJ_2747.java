package BOJ_2747;
//BOJ_2747_피보나치 수 - dp

import java.io.*;
import java.util.*;
public class BOJ_2747 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase_num = Integer.parseInt(br.readLine());
        int [] fibo = new int[46];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i =2; i <= testcase_num; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.println(fibo[testcase_num]);

    }

}
