/*
 * BOJ_1197_최소 스패닝 트리 - 크루스칼
 */
package BOJ_1100.BOJ_1197;

import java.io.*;
import java.util.*;

public class BOJ_1197_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Edge> edges;
    public static int[] parent;
    public static int[] rank;



    public static void main(String[] args) throws IOException{

        //*첫째줄의 정점의 개수V와 간선의 개수 E가 주어진다 */
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //*edge자료형을 담을 인접리스트 생성 */
        edges = new ArrayList<>();

        //*다음 E개의 줄에는 각 간선에 정보를 나타내는 세 정수 A, B, C가 주어진다 */
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }
        Collections.sort(edges);
        makeSet(V);

        int mstWeight = 0;
        int edgeCount = 0;

        for(Edge edge : edges) {
            if(findSet(edge.start) != findSet(edge.end)) {
                union(edge.start, edge.end);
                mstWeight += edge.weight;
                edgeCount++;
            }

            if(edgeCount == V - 1) {
                break;
            }
        }
        System.out.println(mstWeight);
    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void makeSet(int x) {
        parent = new int[x + 1];
        for(int i = 1; i <= x; i++) {
            parent[i] = i;
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
            parent[root_b] = root_a;

        }
    }

}
