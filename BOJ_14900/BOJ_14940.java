package BOJ_14900;

import java.io.*;
import java.util.*;

public class BOJ_14940 {

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int[][] map;
    public static int[][] distance;
    public static boolean[][] visited;

    public static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        map = new int[rows][cols];
        distance = new int[rows][cols];
        visited = new boolean[rows][cols];

        int targetRow = -1, targetCol = -1;

        for(int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < cols; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    targetRow = i;
                    targetCol = j;
                    distance[i][j] = 0;
                } else if(map[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        if(targetRow != -1 && targetCol != -1) {
            bfs(targetRow, targetCol, rows, cols);
        }

        // Output results
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                sb.append(distance[i][j]);
                if(j < cols - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }

    public static void bfs(int startRow, int startCol, int maxRows, int maxCols) {
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(startRow, startCol));
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int curRow = current.row;
            int curCol = current.col;

            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if(nextRow >= 0 && nextRow < maxRows && 
                   nextCol >= 0 && nextCol < maxCols && 
                   !visited[nextRow][nextCol] && 
                   map[nextRow][nextCol] == 1) {
                   
                    visited[nextRow][nextCol] = true;
                    distance[nextRow][nextCol] = distance[curRow][curCol] + 1;
                    queue.offer(new Pair(nextRow, nextCol));
                }
            }
        }
    }
}