//BOJ_2562_최댓값

import java.io.*;
import java.util.*;

public class BOJ_2562 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        
        int max_index = 0;
        int max_num = Integer.MIN_VALUE;

        for(int i = 1; i < 10; i++) {
            int cur_num = Integer.parseInt(br.readLine());
            if(cur_num > max_num) {
                max_num = cur_num;
                max_index = i;
            }
        }
        sb = new StringBuilder();
        sb.append(max_num);
        System.out.println(sb);
        sb = new StringBuilder();
        sb.append(max_index);
        System.out.println(sb);
        br.close();
    }

}
