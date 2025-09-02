//BOJ_1238_파티
package BOJ_1200;

import java.io.*;
import java.util.*;

public class BOJ_1238 {

    public static ArrayList<Edge>[] graph;
    public static ArrayList<Edge>[] reversegraph;

    public static int[] distance;

    public static int[] fromParty;
    public static int[] toParty;

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
        int person = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        graph = new ArrayList[person + 1];
        reversegraph = new ArrayList[person + 1];

        for(int i = 0; i <= person; i++) {
            graph[i] = new ArrayList<>();
            reversegraph[i] = new ArrayList<>();
        }

        distance = new int[person + 1];
        fromParty = new int[person + 1];
        toParty = new int[person + 1];

        for(int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            reversegraph[end].add(new Edge(start, weight));
        }

        dijkstra(graph, target, person);
        for(int i = 1; i <= person; i++) {
            fromParty[i] = distance[i];
        }

        dijkstra(reversegraph, target, person);
        for(int i = 1; i <= person; i++) {
            toParty[i] = distance[i];
        }

        // 3. 최대 왕복시간 계산
        int maxTime = 0;
        for(int i = 1; i <= person; i++) {
            if(i != target) {
                maxTime = Math.max(maxTime, toParty[i] + fromParty[i]);
            }
        }
        System.out.println(maxTime);
    }

    public static void dijkstra(ArrayList<Edge>[] currentGraph, int start, int person) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int cur_end = current.end;
            int cur_weight = current.weight;

            if(cur_weight > distance[cur_end]) continue;

            for(Edge next : currentGraph[cur_end]) {
                int next_end = next.end;
                int next_weight = next.weight;

                int new_dist = distance[cur_end] + next_weight;

                if(new_dist < distance[next_end]) {
                    distance[next_end] = new_dist;
                    pq.offer(new Edge(next_end, new_dist));
                }
            }
        }
    }
}