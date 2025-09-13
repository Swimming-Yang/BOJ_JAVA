package BOJ_2700.BOJ_2747;
//BOJ_2747_피보나치 수 - dp

import java.io.*;
import java.util.*;
public class BOJ_2747 {

    public static int[] fibo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fibo = new int[46];
        fibo[0] = 0;
        fibo[1] = 1;

        int target = Integer.parseInt(br.readLine());
        for(int i =2 ; i <= target; i++) {            
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[target]);

        
    }

}
