//BOJ_15651_N과M 3

package BOJ_15600;

import java.io.*;
import java.util.*;

public class BOJ_15651 {

    public static int[] arr;
    public static int N, R;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[R];
        dfs(0);
        System.out.println(sb);
    
    }

    public static void dfs(int depth) {

        if (depth == R) {
            for (int i = 0; i < R; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }
        for(int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
        
    }
}
