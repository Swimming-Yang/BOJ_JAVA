//BOJ_1753_최단경로

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1753 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Node>[] graph;
    public static int[] distance;
    public static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()); //시작노드임

        //그래프 초기화
        graph = new ArrayList[V + 1];
        distance = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        //거리배열 무한대로 초가화
        Arrays.fill(distance, INF);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Node(end, weight));
        }

        dijkstra(K);//시작노드 다익스트라 실행

        for(int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.weight, other.weight);
        }   
     }

     public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int current_Node = current.end;
            int current_Weight = current.weight;

            if (current_Weight > distance[current_Node]) {
                continue;
            }

            for(Node next : graph[current_Node]) {
                int next_Node = next.end;
                int edgeWeight = next.weight;

                int newDistance = distance[current_Node] + edgeWeight;

                if(newDistance < distance[next_Node]) {
                    distance[next_Node] = newDistance;
                    pq.offer(new Node(next_Node, newDistance));
                }
            }
        }

     }

}
