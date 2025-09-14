//& BOJ_1197 최소 스패닝 트리 - 프림

package BOJ_1100.BOJ_1197;

import java.io.*;
import java.util.*;

public class BOJ_1197_2 {

    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static int Node;

    public static class Node implements Comparable<Node> {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Node = Integer.parseInt(br.readLine());
        int Edge = Integer.parseInt(br.readLine());

        graph = new ArrayList[Node + 1];
        for(int i = 0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }

        int result = prim(1);
        System.out.println(result);
    }

    public static int prim(int start) {
        visited = new boolean[Node + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int mstCost = 0;
        int edge_count = 0;

        visited[start] = true;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            
            if(visited[current.end]) {
                continue;
            }

            visited[current.end] = true;
            mstCost += current.dist;
            edge_count += 1;

            if(edge_count == Node - 1) break;

            for(Node node : graph[current.end]) {
                if(!visited[node.end]) {
                    pq.offer(node);
                }
            }
        }
        return mstCost;
    }
}
