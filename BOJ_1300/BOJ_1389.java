package BOJ_1300;

import java.io.*;
import java.util.*;


public class BOJ_1389 {

    public static int[][] map;
    public static final int INF = 100_000_000;

    // public static class Edge implements Comparable<Edge> {
    //     int end;
    //     int weight;

    //     public Edge(int end, int weight) {
    //         this.end = end;
    //         this.weight = weight;
    //     }

    //     @Override
    //     public int compareTo(Edge o) {
    //         return Integer.compare(this.weight, o.weight);
    //     }
    // }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        map = new int[Node + 1][Node + 1];

        
        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(i == j) map[i][j] = 0;
                else {
                    map[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = 1;

            map[start][end] = Math.min(map[start][end], weight);
            map[end][start] = Math.min(map[end][start], weight);
        }

        for(int mid = 1; mid <= Node; mid++) {
            for(int str = 1; str <= Node; str++) {
                for(int end = 1; end <= Node; end++) {
                    map[str][end] = Math.min(map[str][end], map[str][mid] + map[mid][end]);
                }
            }
        }

        int answer = INF;
        int result = 0;
        
        for(int i = 1; i <= Node; i++) {
            int sum = 0;
            for(int j = 1; j < Node; j++) {
                sum += map[i][j];
            }
            if(sum <= answer) {
                answer = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}
