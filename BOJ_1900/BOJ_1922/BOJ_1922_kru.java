package BOJ_1900.BOJ_1922;

import java.io.*;
import java.util.*;

public class BOJ_1922_kru {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] parent;
    public static ArrayList<Edge> Edges;

    public static int N;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

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

    public static void main(String[] args) throws IOException{
        //*첫째 줄에 컴퓨터의 수 N이 주어진다 */
        N = Integer.parseInt(br.readLine());

        Edges = new ArrayList<>();

        //*둘째 줄에는 연결할 수 있는 선의 수 M이 주어진다(Edge) */
        int M = Integer.parseInt(br.readLine());
        //*셋째 줄부터 M + 2번째 줄까지 총 M개의 줄에 연결하는데 필요한 정보가주어짐 */
        for(int i = 0; i < M; i++) {
            //* a b c // a 부터 b까지 연결하는 비용이 c start, end, weight */
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Edges.add(new Edge(start, end, weight));
        }

        Collections.sort(Edges);
        makeSet(N);

        int mstWeight = 0;
        int edgeCount = 0;

        for(Edge edge : Edges) {
            if(findSet(edge.start) != findSet(edge.end)) {
                union(edge.start, edge.end);
                mstWeight += edge.weight;
                edgeCount++;
                
                if(edgeCount == N - 1) {
                    break;
                }
            }
        }
        System.out.println(mstWeight);
    }

    public static void makeSet(int x) {
        parent = new int[x + 1];
        for(int i = 1; i <= x; i ++) {
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
