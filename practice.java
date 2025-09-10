import java.io.*;
import java.util.*;

public class practice {
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int[][] map;
    public static boolean[][] visited;

    public static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int bechu = Integer.parseInt(st.nextToken());

            map = new int[row][col];
            visited = new boolean[row][col];

            for(int j = 0; j < bechu; j++) {
                st = new StringTokenizer(br.readLine());
                int cr = Integer.parseInt(st.nextToken());
                int cc = Integer.parseInt(st.nextToken());

                map[cr][cc] = 1;
            }

            bfs(0, 0);
        }
    }

    public static void bfs(int cur_r, int cur_c) {
        visited[cur_r][cur_c] = true;
        
    }
}