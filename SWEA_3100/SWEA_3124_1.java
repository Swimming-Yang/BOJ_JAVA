package SWEA_3100;

//SWEA_3124_최소 스패닝 트리_크루스칼
//cspell:ignore SWEA

import java.io.*;
import java.util.*;

public class SWEA_3124_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int V;
    public static int E;

    public static int parent[];
    public static int rank[];

    // Edge 클래스 정의
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);//오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        int testcase_num = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            makeSet(V);
            
            // 간선 리스트 생성
            List<Edge> edges = new ArrayList<>();
            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, w));
                edges.add(new Edge(b, a, w));
            }
            
            Collections.sort(edges);
            
            // 크루스칼 알고리즘
            long mstCost = 0;
            int edgeCount = 0;
            for(Edge edge : edges) {
                if(findSet(edge.from) != findSet(edge.to)) {
                    union(edge.from, edge.to);
                    mstCost += edge.weight;
                    if(++edgeCount == V-1) break;
                }
            }
            
            System.out.println("#" + i + " " + mstCost);
        }
    }

    public static void makeSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int findSet(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        parent[x] = findSet(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int root_a = findSet(a);
        int root_b = findSet(b);

        if(root_a != root_b) {
            if(rank[root_a] > rank[root_b]) {
                parent[root_b] = root_a;
            } else if(rank[root_b] > rank[root_a]) {
                parent[root_a] = root_b;
            } else {
                parent[root_b] = root_a;
                rank[root_a]++;
            }
        }
    }
}
