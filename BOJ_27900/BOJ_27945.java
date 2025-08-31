//&BOJ_7945_슬슬가지를 먹지 않으면 죽는다 */
//cspell:ignore mstday
package BOJ_27900;

import java.io.*;
import java.util.*;

public class BOJ_27945 {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int[] parent;
    
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int day;
        
        public Edge(int start, int end, int day) {
            this.start = start;
            this.end = end;
            this.day = day;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.day - o.day;
        }
    }
    
    public static void makeSet(int N) {
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }
    
    public static int findSet(int N) {
        if(parent[N] == N) {
            return N;
        }
        
        parent[N] = findSet(parent[N]);
        return parent[N];
    }
    
    public static void union(int a, int b) {
        int root_a = findSet(a);
        int root_b = findSet(b);
        
        if(root_a != root_b) {
            parent[root_b] = root_a;
        }
    }
    
    public static void main(String[] args) throws IOException {
        //* 첫째 줄에 요리 학원의 수 N, 길의수 M이 주어진다
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge> edges = new ArrayList<>();
        
        //*M개의 줄에 두 학원 번호 v(i), v(j)길에 있는 노점이 여는날 t(i)가 주어진다 */
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(start, end, day));
        }
        
        makeSet(N);
        Collections.sort(edges);
        
        int mstday = 1;  // 1일차부터 시작
        int edgeCount = 0;
        
        for(Edge edge : edges) {
            if(mstday != edge.day) break;  // 연속성 체크: 현재 날짜와 노점 날짜가 다르면 중단
            if(findSet(edge.start) != findSet(edge.end)) {
                union(edge.start, edge.end);
                mstday++;
                edgeCount++;
                
                if(edgeCount == N - 1) {
                    break;
                }
            }
        }
        System.out.println(mstday);
    }
}