//&BOJ_14938 서강 그라운드
package BOJ_14900.BOJ_14900;

import java.io.*;
import java.util.*;

public class BOJ_14938_dijk {
    
    public static ArrayList<Edge>[] graph;
    public static int[] dist;
    public static int[] weight;
    
    public static final int INF = 100_000_000;
    public static int range;
    public static int Node;
        
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
        
        int max_value = 0;
        
        //*첫째 줄에는 지역의 개수와, 수색범위, 길의개수가 주어진다
        st = new StringTokenizer(br.readLine());
        Node = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());
        
        //*각 그래프 초기화 */
        graph = new ArrayList[Node + 1];
        for(int i = 0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }
        
        weight = new int[Node + 1];
        //* 둘째 줄에는 n개의 숫자가 차례대로 각 구역에 있는 아이템 수를 알려준다.
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= Node; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        
        // 간선 정보 입력 (양방향)
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int edgeWeight = Integer.parseInt(st.nextToken());
            
            // 양방향 간선 추가
            graph[start].add(new Edge(end, edgeWeight));
            graph[end].add(new Edge(start, edgeWeight));
        }
        
        // 각 노드에서 시작하는 다익스트라 실행
        for(int i = 1; i <= Node; i++) {
            int result = dijk(i);
            if (result > max_value) max_value = result;
        }
        
        System.out.println(max_value);
    }
    
    public static int dijk(int start) {
        // dist 배열을 매번 초기화
        dist = new int[Node + 1];
        for(int i = 0; i <= Node; i++) {
            dist[i] = INF;
        }
        
        dist[start] = 0;
        int cur_value = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int cur_end = current.end;
            int cur_weight = current.weight;
            
            if(dist[cur_end] < cur_weight) continue;
            
            for(Edge next : graph[cur_end]) {
                int next_end = next.end;
                int next_weight = dist[cur_end] + next.weight;
                
                if(dist[next_end] > next_weight) {
                    dist[next_end] = next_weight;
                    pq.offer(new Edge(next_end, next_weight));
                }
            }
        }
        
        // 수색범위 내의 모든 아이템 합산
        for(int i = 1; i <= Node; i++) {
            if(dist[i] <= range) {
                cur_value += weight[i];
            }
        }
        return cur_value;
    }
}