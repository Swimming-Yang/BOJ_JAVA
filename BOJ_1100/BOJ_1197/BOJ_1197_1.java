/*
 * BOJ_1197_최소 스패닝 트리 - 크루스칼
 */
package BOJ_1100.BOJ_1197;

import java.io.*;
import java.util.*;

public class BOJ_1197_1 {

    public static ArrayList<Edge> edges;
    public static int[] parent;

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        Collections.sort(edges);
        makeSet(V);

        int mst_weight = 0;
        int edge_count = 0;

        for(Edge edge : edges) {
            if(findSet(edge.start) != (findSet(edge.end))) {
                union(edge.start, edge.end);
                mst_weight += edge.weight;
                edge_count++;
            }
            if(edge_count == V - 1)
            break;
        }
        System.out.println(mst_weight);
    }

    public static void makeSet(int V) {
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    public static int findSet(int x) {
        if(parent[x] == x) return x;

        parent[x] = findSet(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int root_a = findSet(a);
        int root_b = findSet(b);

        if(root_a != root_b) {
            parent[root_b] = root_a;
        }
        
    }


}
