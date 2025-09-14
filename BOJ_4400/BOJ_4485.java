package BOJ_4400;

import java.io.*;
import java.util.*;

public class BOJ_4485 {

    public static int[][] map;
    public static int[][] dist;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int INF = 100_000_000;
    public static int size;

    public static int turn = 0;
    public static class Edge implements Comparable<Edge> {
        int row;
        int col;
        int weight;

        public Edge(int row, int col, int weight) {
            this.row = row;
            this.col = col;
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

    
        while(true) {
            size = Integer.parseInt(br.readLine());
            if(size == 0) {
                break;
            }
            else {
                turn ++;
                map = new int[size][size];
                dist = new int[size][size];

                for(int i = 0; i < size; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < size; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for(int i = 0; i < size; i++) {
                    Arrays.fill(dist[i], INF);
                }

                dijk(0, 0);
                System.out.println("Problem" + " " + turn + ": " + dist[size - 1][size - 1]);
                
            }
        }   
    }

    public static void dijk(int row, int col) {

        dist[row][col] = map[row][col];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(row, col, map[row][col]));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int current_row = current.row;
            int current_col = current.col;
            int current_weight = current.weight;

            if(dist[current_row][current_col] > current_weight) continue;

            for(int i = 0; i < 4; i++) {
                int next_row = current_row + dr[i];
                int next_col = current_col + dc[i];

                if(!(next_row < 0 || next_row >= size || next_col < 0 || next_col >= size)) {
                    if(dist[next_row][next_col] > map[next_row][next_col] + current_weight) {
                        dist[next_row][next_col] = map[next_row][next_col] + current_weight;

                        pq.offer(new Edge(next_row, next_col, dist[next_row][next_col]));
                    }
                }
            }
        }
    }
}
