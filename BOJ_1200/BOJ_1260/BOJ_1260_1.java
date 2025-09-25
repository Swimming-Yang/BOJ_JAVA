//&BOJ_1260_DFS와BFS

package BOJ_1200.BOJ_1260;

import java.io.*;
import java.util.*;

public class BOJ_1260_1 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());
        int start_Node = Integer.parseInt(st.nextToken());

        graph = new ArrayList[Node + 1];
        for(int i = 0; i < Node; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[Node + 1];
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }


        for(int i = 1; i <= Node; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start_Node);
        System.out.println();
        
        visited = new boolean[Node + 1];
        bfs(start_Node);
        System.out.println();
        
    }

    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);

        while(!dq.isEmpty()) {
            int current = dq.poll();
            visited[current] = true;
            System.out.print(current + " ");

            for(int next : graph[current]) {
                if(!visited[next]) {
                    dq.offer(next);
                }
            }
        }
    }
}




