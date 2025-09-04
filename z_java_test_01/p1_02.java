//&돌 던지기 파장

package z_java_test_01;

import java.io.*;
import java.util.*;

public class p1_02 {
    public static int[][] map;
    public static int[] power_arr;

    public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static ArrayList<location>[] loc;

    public static class location{
        int x;
        int y;

        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= testcase_num; i++) {
            int size = Integer.parseInt(br.readLine());
            //*배열은 1부터 시작됨 */
            map = new int[size + 1][size + 1];

            //*돌수, 각 돌돌의 힘의 세기 */
            st = new StringTokenizer(br.readLine());
            int stone = Integer.parseInt(st.nextToken());
            power_arr = new int[stone + 1];
            loc = new ArrayList[stone + 1];
            for(int j = 0; j <= stone; j++) {
                loc[j] = new ArrayList<>();
            }

            for(int j = 1; j <= stone; j++) {
                power_arr[j] = Integer.parseInt(st.nextToken());
            }
            //입력을 받을 좌표
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < stone; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                location temp = new location(x, y);
                loc[j].add(temp);
            }

            //*돌을 던지는 단계 */
            for(int j = 0; j < stone; j++) {
                location current = loc[j].get(0);
                int cur_x = current.x;
                int cur_y = current.y;

                int power = power_arr[j + 1];

                map[cur_x][cur_y] += 1;

                for(int step = 1; step <= power; step++) {
                    for(int k = 0; k < 8; k++) {
                        int nc = cur_x + dc[k] * step;
                        int nr = cur_y + dr[k] * step;

                        if(nc >= 1 && nc <= size && nr >= 1 && nr <= size) {
                            map[nc][nr] += 1;
                        }
                    }
                }
            }
            //*출력부 */
            int max_num = 0;
            for(int j = 1; j <= size; j++) {
                for(int k = 1; k <= size; k++) {
                    if(map[j][k] > max_num) {
                        max_num = map[j][k];
                    }
                }
            }
            System.out.println("#" + i + " " + max_num);
            
        }
    }
}

