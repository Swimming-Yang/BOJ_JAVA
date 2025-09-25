package SWEA_2300;

import java.io.*;
import java.util.*;

public class SWEA_2383 {
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int[][] map;
    public static boolean[][] visited;
    public static int row;
    public static int col;
    public static int mr;
    public static int mc;
    public static int time;

    public static PriorityQueue<Cell> pq;
    public static Queue<Cell> temp;

    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    //*입력의 가장 첫 줄에는 테스트케이스의 개수 T가 주어진다 */
    int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());

            mr = row + 2 * time + 2;
            mc = col + 2 * time + 2;

            map = new int[mr][mc];
            visited = new boolean[mr][mc];
            pq = new PriorityQueue<>();
            temp = new ArrayDeque<>();

            for(int r = 0; r < row; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < col; c++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[mr / 2 - 1 + r][mc / 2 - 1 + c] = num;

                    if(num != 0) {
                        int act_r = mr / 2 - 1 + r;
                        int act_c = mc / 2 - 1 + c;

                        pq.offer(new Cell(act_r, act_c, num, num * 2));
                        visited[act_r][act_c] = true;
                    }
                }
            }
            bfs();
            System.out.println("#" + i + " " + pq.size());
        }
    }

    public static void bfs() {
        for(int t = 1; t <= time; t++) {
            while(!pq.isEmpty()) {
                Cell cur = pq.poll();
                cur.Life_B = cur.Life_B - 1;

                if(cur.Life_A > cur.Life_B) {
                    for(int i = 0; i < 4; i++) {
                        int nr = cur.i + dr[i];
                        int nc = cur.j + dc[i];

                        if(nr >= 0 && nr < mr && nc >= 0 && nc < mc && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            temp.offer(new Cell(nr, nc, cur.Life_A, cur.Life_A * 2));
                        }
                    }
                }
                if(cur.Life_B != 0) {
                    temp.offer(cur);
                }
            }
            while(!temp.isEmpty()) {
                pq.offer(temp.poll());
            }
        }
    }

    public static class Cell implements Comparable<Cell> {
        int i;
        int j;
        int Life_A;
        int Life_B;

        Cell(int i, int j, int Life_A, int Life_B) {
            this.i = i;
            this.j = j;
            this.Life_A = Life_A;
            this.Life_B = Life_B;
        }

        @Override
        public int compareTo(Cell o) {
            return -Integer.compare(Life_A, o.Life_A);
        }
    }
}
