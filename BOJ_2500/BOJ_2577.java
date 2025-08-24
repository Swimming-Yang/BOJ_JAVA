//BOJ_2577_숫자의 개수

import java.io.*;
import java.util.*;

public class BOJ_2577 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] arr;
    public static char[] word;

    public static void main(String[] args) throws IOException{
        int num_A = Integer.parseInt(br.readLine());
        int num_B = Integer.parseInt(br.readLine());
        int num_C = Integer.parseInt(br.readLine());
        
        int sum_num = num_A * num_B * num_C;

        word = ("" + sum_num).toCharArray();
        arr = new int[10];

        for(int i = 0; i < word.length; i++) {
            int cur_alpha = word[i] - '0';
            arr[cur_alpha] += 1;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}

