//BOJ_1753_최단경로

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    
    public static ArrayList<Node>[] graph;
    public static int[] dist;

    public static int INF = 100_000_000;

    public static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

        
    }
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());
        int str_Node = Integer.parseInt(br.readLine());

        graph = new ArrayList[Node + 1];
        for(int i = 0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[Node + 1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        dijk(str_Node);

        for(int i = 1; i <= Node; i++) {
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    public static void dijk(int start_Node) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        //*시작자기자신까지의 거리는 0 */
        dist[start_Node] = 0;
        pq.offer(new Node(start_Node, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int cur_Node = cur.end;
            int cur_dist = cur.weight;

            if(cur_dist > dist[cur_Node]) continue;
            
            for(Node next : graph[cur_Node]) {
                int next_Node = next.end;
                int next_dist = next.weight;

                int new_dist = dist[cur_Node] + next_dist;

                if(new_dist < dist[next_Node]) {
                    dist[next_Node] = new_dist;
                    pq.offer(new Node(next_Node, new_dist));
                }
            }
        }
        
    }
}
