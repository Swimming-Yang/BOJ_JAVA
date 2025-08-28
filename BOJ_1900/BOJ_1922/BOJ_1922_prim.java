//BOJ_1922_네트워크연결_프림

package BOJ_1900.BOJ_1922;

import java.io.*;
import java.util.*;

public class BOJ_1922_prim {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean[] visited;
    public static ArrayList<Edge>[] graph;

    public static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException{
        int com_num = Integer.parseInt(br.readLine());
        int line_num = Integer.parseInt(br.readLine());

        //^초기화좀 잘해라 */
        graph = new ArrayList[com_num + 1];
        for(int i = 0; i <= com_num; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < line_num; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            graph[end].add(new Edge(start, weight));
        }

        int mstWeight = prim(com_num);
        System.out.println(mstWeight);
    }

    public static int prim(int com_num) {
        visited = new boolean[com_num + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int totalWeight = 0;
        int edgeCount = 0;

        int start_node = 1;
        visited[start_node] = true;

        for(Edge edge : graph[start_node]) {
            pq.offer(edge);
        }

        while(!pq.isEmpty() && edgeCount < com_num - 1) {
            Edge current = pq.poll();

            if(visited[current.end]) {
                continue;
            }

            visited[current.end] = true;
            totalWeight += current.weight;

            for(Edge edge : graph[current.end]) {
                if(!visited[edge.end]) {
                    pq.offer(edge);
                }
            }
        }
        return totalWeight;
    }

}
