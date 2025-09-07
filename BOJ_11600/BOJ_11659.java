//& BOJ_11659_구간 합 구하기 4

package BOJ_11600;

import java.io.*;
import java.util.*;

public class BOJ_11659 {

    public static int[] num_list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //*첫째 줄에 수의 개수 N과 합을 구해야하는 횟수 M이 주어진다. */
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        num_list = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int cur_sum = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start - 1; j < end; j++) {
                cur_sum += num_list[j];
            }
            System.out.println(cur_sum);
            cur_sum = 0;
        }
    }

}
