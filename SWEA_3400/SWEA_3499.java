package SWEA_3400;

import java.io.*;
import java.util.*;

public class SWEA_3499 {

    public static String[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcase_num = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testcase_num; tc++) {
            int size = Integer.parseInt(br.readLine());

            arr = new String[size];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                arr[j] = st.nextToken();
            }

            Deque<String> dq1 = new ArrayDeque<>();
            Deque<String> dq2 = new ArrayDeque<>();

            if(size % 2 == 0) {
                int half = size / 2;
                for(int j = 0; j < half; j++) {
                    dq1.offer(arr[j]);
                }
                for(int j = half; j < size; j++) {
                    dq2.offer(arr[j]);
                }
            } else {
                int half = size / 2;
                for(int j = 0; j <= half; j++) {
                    dq1.offer(arr[j]);
                }
                for(int j = half + 1; j < size; j++) {
                    dq2.offer(arr[j]);
                }
            }

            sb.append("#").append(tc).append(" ");
            
            while(!dq1.isEmpty() || !dq2.isEmpty()) {
                if(!dq1.isEmpty()) {
                    sb.append(dq1.poll()).append(" ");
                }
                if(!dq2.isEmpty()) {
                    sb.append(dq2.poll()).append(" ");
                }
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}