//BOJ_1753_최단경로

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1753 {

    public static ArrayList<Edge>[] graph;
    public static int distance[];

    public static int INF = Integer.MAX_VALUE;

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
        //*첫번째 줄에 정점의 개수V와 간선의 개수E가 주어진다 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //*둘째 줄에는 시작 정점의 번호 K가 주어진다 */
        int start_node = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        for(int i = 0; i < E; i++) {
            //*다음 E줄에 걸쳐 각 간선을 나타내는 세개의 정수가 순서대로 주어진다 */
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }
        
        Dijkstra(start_node, V);
    }

    public static void Dijkstra(int start_node, int V) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start_node] = 0;
        
        pq.offer(new Edge(start_node, distance[start_node]));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int cur_end = current.end; //*현재 처리할 정점번호 */
            int cur_weight = current.weight;//*그 정점까지의 거리 */

            if(cur_weight > distance[cur_end]) continue; //*그 정점까지의 거리가 이미저장된 거리보다 크면 무시

            for(Edge next : graph[cur_end]){ //*현재 정점과 연결된 모든 정점 검사 */
                int next_end = next.end;//*연결된 정점1 */
                int next_weight = next.weight;//*연결된 정점1의 거리 */

                int new_dist = distance[cur_end] + next_weight; //*새로운 거리 = 현재정점거리(누적) + 정점1까지의 거리 */

                if(new_dist < distance[next_end]) { //*새로운 거리가 정점1의 저장된 최소거리보다 작다면 */
                    distance[next_end] = new_dist; //*최단거리 갱신 */
                    pq.offer((new Edge(next_end, new_dist))); //* 갱신된 정보 큐에 삽입
                }
            }
        }
        for(int i = 1; i <= V; i++){
            System.out.println((distance[i] == INF)? "INF" : distance[i] );
        }
    }

}
