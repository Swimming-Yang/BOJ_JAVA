import java.io.*;
import java.util.*;

public class BOJ_20040 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] parent;

    static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end));
        }

        makeSet(n);

        int edgeCount = 0;
        boolean cycleFound = false;

        for(Edge edge : edges) {
            edgeCount++;
            
            if(findSet(edge.start) == findSet(edge.end)) {
                cycleFound = true;
                System.out.println(edgeCount);
                return;
            }

            union(edge.start, edge.end);
        }

        if(!cycleFound) {
            System.out.println(0);
        }
    }

    public static void makeSet(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public static int findSet(int n) {
        if(parent[n] == n) return n;
        
        parent[n] = findSet(parent[n]);
        return parent[n];
    }
    
    public static void union(int a, int b) {
        int root_a = findSet(a);
        int root_b = findSet(b);
        
        if(root_a != root_b) {
            parent[root_b] = root_a;
        }
    }
}