//BOJ_1753_최단경로

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    public static ArrayList<Edge>[] graph;
    public static int[] distance;

    public static int INF = Integer.MAX_VALUE;

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
        StringTokenizer st;

        //^정점의 개수, 간선의 개수
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        //^시작노드
        int K = Integer.parseInt(br.readLine());

        //^ E줄에 걸쳐 시작, 도착, 가중치
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        Dijkstra(K);
    }

    public static void Dijkstra(int start_node) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        distance[start_node] = 0;
        pq.offer(new Edge(start_node, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int cur_node = current.end;
            int cur_weight = current.weight;

            if(distance[cur_node] < cur_weight) continue;

            for(Edge next : graph[cur_node]) {
                int next_node = next.end;
                int next_weight = next.weight;

                int new_dist = distance[cur_node] + next_weight;
                
                if(new_dist < distance[next_node]) {
                    distance[next_node] = new_dist;
                    pq.offer(new Edge(next_node, new_dist));
                }
            }
        }
        for(int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] == INF ? "INF" : distance[i]);
        }
    }

}
