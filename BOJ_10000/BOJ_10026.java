//BOJ_10026_적록색약

package BOJ_10000;

import java.io.*;
import java.util.*;

public class BOJ_10026 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static String[][] map;
    public static String[][] current_map;
    public static boolean[][] visited;

    public static int map_size;

    public static void main(String[] args) throws IOException{
        map_size = Integer.parseInt(br.readLine());

        map = new String[map_size + 1][map_size + 1];
        visited = new boolean[map_size + 1][map_size + 1];

        for(int i = 1; i <= map_size; i++) {
            String line = br.readLine();
            for(int j = 1; j <= line.length(); j++) {
                String alpha = String.valueOf(line.charAt(j - 1));
                map[i][j] = alpha;
            }
        }
        //일반인 경우
        current_map = map;
        int count = 0;

        for(int i = 1; i <=map_size; i++) {
            for(int j = 1; j <= map_size; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        //적록색약의 경우
        visited = new boolean[map_size + 1][map_size + 1];

        String redarr[][] = new String[map_size + 1][map_size + 1];
        for(int i = 0; i <= map_size; i++) {
            for(int j =0; j <= map_size; j++) {
                redarr[i][j] = map[i][j];
            }
        }
        
        for(int i = 1; i <= map_size; i++) {
            for(int j = 1; j <=map_size; j++) {
                if (redarr[i][j].equals("G")) {
                    redarr[i][j] = "R";
                }
            }
        }
        current_map = redarr;
        int red_count = 0;
        for(int i = 1; i <=map_size; i++) {
            for(int j = 1; j <= map_size; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    red_count++;
                }
            }
        }
                System.out.println(count + " " + red_count);
    }

    public static void dfs(int cur_x, int cur_y) {
        visited[cur_x][cur_y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];

            if(nx >= 1 && nx < map_size + 1 && ny >= 1 && ny < map_size + 1) {
                if(!visited[nx][ny] && current_map[cur_x][cur_y].equals(current_map[nx][ny])){
                    dfs(nx, ny);
                }
                }
            }
        }
    }



