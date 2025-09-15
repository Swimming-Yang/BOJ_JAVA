package BOJ_1400;

import java.io.*;
import java.util.*;

public class BOJ_1446 {

    public static ArrayList<Edge>[] graph;
    public static int[] dist;

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
        int edgeCount = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        graph = new ArrayList[total + 1];
        dist = new int[total + 1];
        
        for(int i = 0; i <= total; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < total; i++) {
            graph[i].add(new Edge(i + 1, 1));
        }


        for(int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            

            if (end <= total && weight < (end - start)) {
                graph[start].add(new Edge(end, weight));
            }
        }

        dijkstra(0);
        
        System.out.println(dist[total]);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.end;
            int currentDist = current.weight;
            
            if(currentDist > dist[currentNode]) continue;
            
            for(Edge edge : graph[currentNode]) {
                int newDist = dist[currentNode] + edge.weight;
                if(newDist < dist[edge.end]) {
                    dist[edge.end] = newDist;
                    pq.offer(new Edge(edge.end, newDist));
                }
            }
        }
    }
}