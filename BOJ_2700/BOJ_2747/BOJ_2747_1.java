//BOJ_2747_1 피보나치 수 - 재귀

package BOJ_2747;

import java.io.*;
import java.util.*;

public class BOJ_2747_1 {

    static int [] fibo_arr;
    static int testcase_num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testcase_num = Integer.parseInt(br.readLine());
        
        System.out.println(fibo(testcase_num));
    }


    public static int fibo(int testcase_num) {
        if (testcase_num == 0) {
            return 0;
        }

        if (testcase_num == 1) {
            return 1;
        }

        return fibo(testcase_num - 1) + fibo(testcase_num - 2); 
    
        }
    }
