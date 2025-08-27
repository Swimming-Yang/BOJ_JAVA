//SWEA_3124_최소 스패닝 트리_프림
//cspell:ignore SWEA

package SWEA_3100;

import java.io.*;
import java.util.*;

public class SWEA_3124_2 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    // 간선 정보를 저장하는 클래스
    static class Edge implements Comparable<Edge> {
        int to;     // 간선이 연결된 목적지 정점
        int weight; // 간선의 가중치

        // Edge 객체 생성자
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        // 우선순위 큐에서 가중치를 기준으로 오름차순 정렬하기 위한 메소드
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException{

        int testcase_num = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= testcase_num; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수

            //* 정점 개수만큼 인접 리스트 배열을 초기화 (1번 인덱스부터 시작)
            graph = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            //* E개의 간선 정보를 읽어서 그래프에 저장
            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); // 시작
                int B = Integer.parseInt(st.nextToken()); // 끝
                int C = Integer.parseInt(st.nextToken()); // 가중치
                
                // 무방향 그래프이므로 양쪽 방향으로 간선 추가
                graph[A].add(new Edge(B, C)); // A에서 B로 가는 간선
                graph[B].add(new Edge(A, C)); // B에서 A로 가는 간선
            }

            long mstWeight = prim(V);
            System.out.println("#" + t + " " + mstWeight);
        }
    }
    public static long prim(int V) {
        // 초기화
        visited = new boolean[V + 1];
        // 우선순위 큐
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long totalWeight = 0;
        int edgeCount = 0;

        // 임의의 시작노드 지정
        visited[1] = true;
        // 시작 노드에서 연결된 모든 간선을 우선순위 큐에 추가
        for(Edge edge : graph[1]) {
            pq.offer(edge);
        }

        // 조건: 큐가 비지 않았고 간선의 개수가 V-1개가 되지 않았다면 계속
        while(!pq.isEmpty() && edgeCount < V - 1) {
            // 우선순위 큐에 의해서 가장 작은 가중치의 간선을 poll
            Edge current = pq.poll();

            if(visited[current.to]) {
                continue;
            }

            // 방문배열 갱신
            visited[current.to] = true;
            // 가중치 갱신
            totalWeight += current.weight;
            edgeCount++;

            // 현재 정점에서 연결된 모든 간선들을 큐에 추가
            for(Edge edge : graph[current.to]) {
                // 아직 방문하지 않은 정점으로 가는 간선만 우선순위 큐에 추가
                if(!visited[edge.to]) {
                    pq.offer(edge);
                }
            }
        }
        // MST의 총 가중치 반환
        return totalWeight;
    }
}