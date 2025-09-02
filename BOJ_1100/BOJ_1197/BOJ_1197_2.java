//& BOJ_1197 최소 스패닝 트리 - 프림

package BOJ_1100.BOJ_1197;

import java.io.*;
import java.util.*;

public class BOJ_1197_2 {
    
    public static ArrayList<Edge>[] graph;
    public static boolean[] visited;

    public static int V;

    public static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[V + 1];


        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            graph[end].add(new Edge(start, weight));
        }

        int result = prim(1);
        System.out.println(result);

    }

    public static int prim(int start) {

        visited[start] = true;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(Edge edge : graph[start]) {
            pq.offer(edge);
        }

        int mst_cost = 0;
        int edge_count = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if(visited[current.end]) continue;

            visited[current.end] = true;
            mst_cost += current.weight;
            edge_count+= 1;

            if(edge_count == V - 1) {
                break;
            }

            for(Edge edge : graph[current.end]) {
                if(!visited[edge.end]) {//방문하지 않았다면
                pq.offer(edge);
                }
            }
        }
        return mst_cost;
    }
}
