/*
 * 최단거리 BFS
 * 
 */

package AlGO.완전탐색.BFS;

import java.io.*;
import java.util.*;

public class BFS_3 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int[] distance;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList[Node + 1];
        visited = new boolean[Node + 1];
        distance = new int[Node + 1];

        for(int i = 1; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        st = new StringTokenizer(br.readLine());
        int start_node = Integer.parseInt(st.nextToken());
        int target_node = Integer.parseInt(st.nextToken());

        int result = bfs(start_node, target_node);
        System.out.println("최단거리: " + result);

        }

        public static int bfs(int start_node, int target_node) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(start_node);
            visited[start_node] = true;
            distance[start_node] = 0;

            while(!q.isEmpty()) {
                int node = q.poll();

                if (node == target_node) {
                    return distance[node];
                }

                for (int next : graph[node]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        distance[next] = distance[node] + 1;
                        q.offer(next);
                    }                
                }
            }



            return -1;
        }
    }

