package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int basket_num = Integer.parseInt(st.nextToken());
        int testcase_num = Integer.parseInt(st.nextToken());

        int[] arr = new int[basket_num + 1];

        for(int i = 1; i <= basket_num; i++) {
            arr[i] = i;
        }

        // 공 바꾸기
        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int basket1 = Integer.parseInt(st.nextToken());
            int basket2 = Integer.parseInt(st.nextToken());

            // 두 바구니의 공을 교환
            int temp = arr[basket1];
            arr[basket1] = arr[basket2];
            arr[basket2] = temp;
        }

        // 결과 출력 (1번 바구니부터)
        for(int i = 1; i <= basket_num; i++) {
            sb.append(arr[i] + " ");
        }

        System.out.print(sb);
    }
}