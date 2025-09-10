//&BOJ_2667_단지 번호 붙이기

package BOJ_2600.BOJ_2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_dfs {

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static int[][] map;
    public static boolean[][] visited;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size][size];

        List<Integer> sizes = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    sizes.add(dfs(i, j, size));
                    count++;
                }
            }
        }
        Collections.sort(sizes);
        System.out.println(count);
        for(int answer : sizes) {
            System.out.println(answer);
        }
    }

    public static int dfs(int cr, int cc, int size) {
        visited[cr][cc] = true;
        int cur_size = 1;
        
        for(int i = 0; i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];

            if(nr >= 0 && nr < size && nc >= 0 && nc < size) {
                if(!visited[nr][nc] && map[nr][nc] == 1) {
                    cur_size += dfs(nr, nc, size);
                }
            }
        }

        return cur_size;
    }

}
