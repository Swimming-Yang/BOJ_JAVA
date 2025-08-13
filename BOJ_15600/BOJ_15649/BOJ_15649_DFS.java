package BOJ_15600.BOJ_15649;

import java.io.*;
import java.util.*;

public class BOJ_15649_DFS {

    public static int N;
    public static int R;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[R];
        visited = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == R) {
            for(int num : arr) {
                sb.append(num + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
            dfs(depth + 1);
            visited[i] = false; 
           }
        }
    }
}
    
