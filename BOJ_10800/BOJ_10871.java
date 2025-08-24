//BOJ_10871_X보다 작은 수
package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10871 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuffer sb;
    
    public static int arr_num;
    public static int target_num;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        arr_num = Integer.parseInt(st.nextToken());
        target_num = Integer.parseInt(st.nextToken());

        //초기화
        sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr_num; i++) {
            int cur_num = Integer.parseInt(st.nextToken());
            if(cur_num < target_num) {
                sb.append(cur_num).append(" ");
            }
        }

        System.out.println(sb);
        br.close();

        
    }

}
