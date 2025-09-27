package BOJ_5900;

import java.io.*;
import java.util.*;

public class BOJ_5872 {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫째줄에서 N과 M을 올바르게 읽기
        st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());  // N: 노드 개수
        int edge = Integer.parseInt(st.nextToken());  // M: 간선 개수

        // 그래프 초기화
        graph = new ArrayList[node + 1];
        for(int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        // 거리 배열 초기화
        dist = new int[node + 1];
        for(int i = 1; i <= node; i++) {
            dist[i] = INF;
        }

        // 간선 정보 입력
        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            graph[end].add(new Edge(start, weight));  // 양방향 그래프
        }

        // 다익스트라 실행 (1번 노드에서 시작)
        dijk(1);
        
        // N번 노드까지의 최단거리 출력
        System.out.println(dist[node]);
    }

    public static void dijk(int start) {
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int cur_node = current.end;
            int cur_weight = current.weight;

            // 이미 처리된 노드라면 건너뛰기
            if(dist[cur_node] < cur_weight) continue;

            // 인접한 노드들 확인
            for(Edge next : graph[cur_node]) {
                int next_node = next.end;
                int next_weight = dist[cur_node] + next.weight;  // 수정된 부분

                if(dist[next_node] > next_weight) {
                    dist[next_node] = next_weight;
                    pq.offer(new Edge(next_node, next_weight));
                }
            }
        }
    }
}
