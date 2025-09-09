//BOJ_2667_단지번호붙이기 *
package BOJ_2600.BOJ_2667;

import java.io.*;
import java.util.*;

public class BOJ_2667 {

    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int testcase_num;

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < testcase_num && ny < testcase_num) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    size += dfs(nx, ny);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase_num = Integer.parseInt(br.readLine());
        arr = new int[testcase_num][testcase_num];
        visited = new boolean[testcase_num][testcase_num];

        for (int i = 0; i < testcase_num; i++) {
            String line = br.readLine();
            for (int j = 0; j < testcase_num; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> sizes = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < testcase_num; i++) {
            for (int j = 0; j < testcase_num; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    sizes.add(dfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(sizes);
        System.out.println(count);
        for (int s : sizes) {
            System.out.println(s);
        }
    }
}