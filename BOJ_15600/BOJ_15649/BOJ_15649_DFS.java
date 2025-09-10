package BOJ_15600.BOJ_15649;

import java.io.*;
import java.util.*;

public class BOJ_15649_DFS {

    public static int N;                //선택 배열범위
    public static int R;                //선택할 개수
    public static int[] current;            //현재 순열
    public static boolean[] visited;     //방문 여부 배열
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());   //배열의 길이는?
        R = Integer.parseInt(st.nextToken());   //몇개를 선택?

        current = new int[R];                       //현재 배열 초기회
        visited = new boolean[N];               //방문 배열 초기화

        dfs(0);                           //깊이 0부터 dfs 시작 
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == R) {
            for(int num : current) {
                sb.append(num + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current[depth] = i + 1;
            dfs(depth + 1);
            visited[i] = false; 
            }
        }
    }
}
    
