package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10811 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr_len = Integer.parseInt(st.nextToken());
        int testcase_num = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int j = 1; j <= arr_len; j++) {
            arr.add(j);
        }

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int st_num = Integer.parseInt(st.nextToken());
            int ed_num = Integer.parseInt(st.nextToken());

            int left = st_num -1;
            int right = ed_num -1;

            while(left < right) {
                int temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);

                left++;
                right--;
            }


        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append(" ");
        }
                System.out.println(sb);
    }

}
