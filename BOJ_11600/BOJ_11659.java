//& BOJ_11659 구간 합 구하기 4;

package BOJ_11600;

import java.io.*;
import java.util.*;

public class BOJ_11659 {
    public static int[] prefix_sum;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 첫째 줄에 수의 개수 N과 합을 구해야하는 횟수 M이 주어진다.
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        prefix_sum = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefix_sum[i] = prefix_sum[i-1] + num;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int result = prefix_sum[end] - prefix_sum[start - 1];
            System.out.println(result);
        }
    }
}