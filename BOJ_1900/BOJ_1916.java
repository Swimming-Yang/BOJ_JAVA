//BOJ_1916_최소비용구하기

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1916 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Node>[] graph;
    public static int[] dist;

    public static int INF = 100_000_000;

    public static class Node implements Comparable<Node> {
        int end;
        int dist;

        Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException{
        int Node = Integer.parseInt(br.readLine());
        int Edge = Integer.parseInt(br.readLine());

        graph = new ArrayList[Node + 1];
        for(int i = 0; i <= Node ; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[Node + 1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, dist));
        }
        st = new StringTokenizer(br.readLine());
        int start_city = Integer.parseInt(st.nextToken());
        int end_city = Integer.parseInt(st.nextToken());

        dijk(start_city);

        if(dist[end_city] == INF) return;
        else System.out.println(dist[end_city]);
    }

    public static void dijk(int start) {

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int cur_Node = current.end;
            int cur_dist = current.dist;

            if(dist[cur_Node] < cur_dist) continue;
            else {
                for(Node next : graph[cur_Node]) {
                    int next_Node = next.end;
                    int next_dist = next.dist;

                    int new_dist = dist[cur_Node] + next_dist;
                    if(new_dist < dist[next_Node]) {
                        dist[next_Node] = new_dist;
                        pq.offer(new Node(next_Node, new_dist));
                    }

                }
            }
        }    
    }
}