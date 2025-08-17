/*
 * 트리 레벨 BFS
 */

package AlGO.완전탐색.BFS;

import java.io.*;
import java.util.*;

public class BFS_4 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        graph = new ArrayList[Node + 1];
        visited = new boolean[Node + 1];
        
        for (int i = 1; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        bfs(1);
    }


    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            System.out.print("Level" + level + ": ");

            for(int i =0; i < size; i++) {
                int node = q.poll();
                System.out.print(node + " ");

                for (int next : graph[node]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            System.out.println();
            level++;
        }
        }

}
