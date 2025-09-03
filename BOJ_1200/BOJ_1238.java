//BOJ_1238_파티
package BOJ_1200;

import java.io.*;
import java.util.*;

public class BOJ_1238 {

    public static ArrayList<Edge>[] graph;
    public static ArrayList<Edge>[] reverse_graph;

    public static int[] distance;
    public static int[] reverse_distance;

    public static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        public Edge(int end, int weight) {
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
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for(int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            reverse_graph = new ArrayList[N + 1];
            for(int i = 0; i <= N; i++) {
                reverse_graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[start].add(new Edge(end, weight));
                reverse_graph[end].add(new Edge(start, weight));
            }

            Dijkstra()
        }
    }

