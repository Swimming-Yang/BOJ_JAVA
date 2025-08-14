package BOJ_11700.BOJ_11724;

import java.io.*;
import java.util.*;

public class BOJ_11724_1 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;

    public static int Node;
    public static int Edge;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        Node = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());

        visited = new boolean[Node + 1];
        graph = new ArrayList[Node + 1];
        for(int i = 1; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        int answer_count = 0;

        for(int i = 1; i <= Node; i++) {
            if(!visited[i]) {
                dfs(i);
                answer_count++;
            }
        }
        System.out.println(answer_count);
    }
    
    public static void dfs(int start) {
        visited[start] = true;

        for(int next_node : graph[start]) {
            if(!visited[next_node]) {
                dfs(next_node);
            }
        }
    }
}