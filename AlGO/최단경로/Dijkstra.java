package AlGO.최단경로;

import java.io.*;
import java.util.*;

public class Dijkstra {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    //그래프 인접리스트 저장
    public static ArrayList<Node>[] graph;

    //시작점에서 각 정점까지 최단거리 저장
    public static int[] distance;

    //무한대를 나타내는 상수(도달 불가능 한경우)
    public static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException{
        //입력받기 : V(노드 개수), E(간선 갯수), K(시작 노드)
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList[V + 1];
        distance = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }


        //거리배열 무한대로 초기화
        Arrays.fill(distance, INF);

        //간선 정보 입력
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //일방향 그래프 한쪽만 추가
            graph[start].add(new Node(end, weight));

            //무방향 그래프라면 양방향으로 추가해야함
            //graph[end].add(new Node(start, weight));
        }

        //다익스트라 알고리즘 실행
        dijkstra(K); //K는 시작 노드였음

        //결과 출력
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF"); //도달 불가능
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    /*
     * 간선 정보를 저장하는 Node 클래스
     * - end: 도착 정점 번호
     * - weight: 간선의 가중치
     */

     static class Node implements Comparable<Node> {
        int end; //도착 정점
        int weight; //가중치

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
     }

     public static void dijkstra(int start) {
        //우선순위 큐 사용 (가중치가 작은 순서대로 자동 정렬)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //시작 정점의 거리 0으로 설정
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int current_Node = current.end;
            int current_Weight = current.weight;

            //이미 더 가까운게 있으면 패스
            if (current_Weight > distance[current_Node]) {
                continue;
            }

            for (Node next : graph[current_Node]) {
                int next_Node = next.end;
                int edgeWeight = next.weight;

                //현재 정점 + 다음 정점
                int newDistance = distance[current_Node] + edgeWeight;

                //더 짧은거리 발견
                if(newDistance < distance[next_Node]) {
                    distance[next_Node] = newDistance;
                    pq.offer(new Node(next_Node, newDistance));
                }
            }
        }
     }

    



}
