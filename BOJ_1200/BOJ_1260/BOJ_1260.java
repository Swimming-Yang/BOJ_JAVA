//BOJ_1260 DFS와 BFS

package BOJ_1200.BOJ_1260;

import java.io.*;
import java.util.*;


public class BOJ_1260 {

    static boolean [] visited;
    static int [][] arr;

    static int node;
    static int edge;
    static int start;

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for (int next_node = 1; next_node <= node; next_node++) {
            if (arr[start][next_node] == 1 && !visited[next_node]) {
                dfs(next_node);
            }
        }
    }

    public static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);

        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current + " ");

            for(int next_node = 1; next_node <= node; next_node++) {
                if (arr[current][next_node] == 1 && !visited[next_node]) {
                    visited[next_node] = true;
                    q.offer(next_node);
                }
            }
        }


    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            
            arr[start_node][end_node] = arr[end_node][start_node] = 1; //배열에 값 넣기 끝
        }

        dfs(start);
        System.out.println(sb);

        visited = new boolean[node + 1];
        sb = new StringBuilder();

        bfs(start);
        System.out.println(sb);

        
    }

}
