//BOJ_1916_최소비용구하기

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1916 {

    public static ArrayList<Edge>[] graph;
    public static int[] dist;

    public static int INF = 123_456_789;

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

        int Node = Integer.parseInt(br.readLine());
        int Edge = Integer.parseInt(br.readLine());

        graph = new ArrayList[Node + 1];
        for(int i = 0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[Node + 1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start_Node = Integer.parseInt(st.nextToken());
            int end_Node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start_Node].add(new Edge(end_Node, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijk(start);
        System.out.println(dist[end]);
    }

    public static void dijk(int start) {
        //*자기 자신의 거리는 당연히 0 */
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int current_Node = current.end;
            int current_Weight = current.weight;

            if(dist[current_Node] < current_Weight) continue;

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