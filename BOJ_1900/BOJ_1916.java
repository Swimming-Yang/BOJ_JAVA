//BOJ_1916_최소비용구하기

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1916 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Node>[] graph;
    public static int distance[];
    public static final int INF = Integer.MAX_VALUE;
    
    // 커스텀 Node 클래스 정의
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;
        
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public static void main(String[] args) throws IOException{
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        // 초기화
        graph = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        // 간선 정보 입력
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        // 시작점과 끝점 입력
        st = new StringTokenizer(br.readLine());
        int start_node = Integer.parseInt(st.nextToken());
        int end_node = Integer.parseInt(st.nextToken());

        dijkstra(start_node);

        System.out.println(distance[end_node]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int cur_vertex = current.vertex;
            int cur_weight = current.weight;


            if(cur_weight > distance[cur_vertex]) continue;

            // 인접한 노드들 확인
            for(Node next : graph[cur_vertex]) {
                int next_vertex = next.vertex;
                int next_weight = distance[cur_vertex] + next.weight;
                
                // 더 짧은 경로 발견시 업데이트
                if(next_weight < distance[next_vertex]) {
                    distance[next_vertex] = next_weight;
                    pq.offer(new Node(next_vertex, next_weight));
                }
            }
        }
    }
}