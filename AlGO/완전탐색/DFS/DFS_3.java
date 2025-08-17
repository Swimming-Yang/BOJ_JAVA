/*
 * stack기반 DFS
 * 
 * 
 */

package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_3 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList[Node + 1];
        visited = new boolean[Node + 1];

        for (int i = 1; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }
        dfs(1); //1번 노드부터
    }



    public static void dfs(int start) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(!visited[node]) {
                visited[node] = true;
                System.out.println("방문 처리한 노드 :" + node);
            }

            for(int next : graph[node]) {
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }



}
