package BOJ_10800;

import java.io.*;
import java.util.*;
public class BOJ_10813 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int basket_num = Integer.parseInt(st.nextToken());
        int testcase_num = Integer.parseInt(st.nextToken());

        int [] arr = new int[basket_num];

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int num_1 = Integer.parseInt(st.nextToken());
            int num_2 = Integer.parseInt(st.nextToken());

            arr[num_1 - 1] = num_2;
            arr[num_2 - 1] = num_1;            
        }

        for(int j = 0; j < arr.length; j++) {
            sb.append(arr[j] + " ");
        }

        System.out.print(sb);
        
    }

}
