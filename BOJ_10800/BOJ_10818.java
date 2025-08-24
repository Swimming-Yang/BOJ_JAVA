//BOJ_10818_최소, 최대

package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10818 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());
        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < testcase_num; i++) {
            int cur_num = Integer.parseInt(st.nextToken());
            if(cur_num > max_num) {
                max_num = cur_num;
            }
            if(cur_num < min_num) {
                min_num = cur_num;
            }
        }

        System.out.print(min_num + " " + max_num);
        
    }

}
