//BOJ_1753_최단경로

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1753 {

    public static ArrayList<Edge>[] graph;
    public static int[] dist;
    public static int INF = 100_000_000;

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

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        graph = new ArrayList[Node + 1];
        for(int i = 0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[Node + 1];
        Arrays.fill(dist, INF);

        int start_Node = Integer.parseInt(br.readLine());

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        dijk(start_Node);

        for(int i = 1; i <= Node; i++) {
            if(dist[i] == INF) {
                System.out.println("INF");
            }
            else {
            System.out.println(dist[i]);
            }
        }
    }

    public static void dijk(int start_Node) {
        dist[start_Node] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start_Node, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int current_Node = current.end;
            int current_weight = current.weight;

            if(dist[current_Node] < current_weight) continue;

            for(Edge next : graph[current_Node]) {
                int next_Node = next.end;
                int next_Weight = dist[current_Node] + next.weight;

                if(dist[next_Node] > next_Weight) {
                    dist[next_Node] = next_Weight;

                    pq.offer(new Edge(next_Node, next_Weight));
                }
            }
        }
    }
}
