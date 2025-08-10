//BOJ_1260 DFS와 BFS 기본 템플릿 연습

package BOJ_1200;

import java.io.*;
import java.util.*;


public class BOJ_1260_1 {

    static boolean[] visited;
    static int [][] map;

    static int node;
    static int edge;
    static int start_node;

    static StringBuilder sb;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start_node = Integer.parseInt(st.nextToken());

        map = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = map[end][start] = 1;
        }

        dfs(start_node);
        System.out.println(sb);

        sb = new StringBuilder(); //스트링 빌더 초기화
        visited = new boolean[node + 1]; // 방문배열 초기화

        bfs(start_node);
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int start_node) {
        visited[start_node] = true;
        sb.append(start_node + " ");
        
        for(int next_node = 1; next_node <= node; next_node++) {
            if(map[start_node][next_node] == 1 && !visited[next_node]) {
                dfs(next_node);
            }
        }
    }

    public static void bfs(int start_node) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start_node);
        visited[start_node] = true;

        while(!q.isEmpty()) {
            int current_node = q.poll();
            sb.append(current_node + " ");

            for(int next_node = 1; next_node <= node; next_node++) {
                if(map[current_node][next_node] == 1 && !visited[next_node]) {
                    visited[next_node] = true;
                    q.offer(next_node);
                }
            }
        }
    }
}



