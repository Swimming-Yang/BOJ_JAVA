//&BOJ_16236_아기상어

package BOJ_16200;

import java.io.*;
import java.util.*;

public class BOJ_16236 {

    //*탐색배열 위쪽 상 -> 왼 -> 하 -> 오 */
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static int[][] map;
    public static boolean[][] visited;
    //*물고기의 크기 */
    public static int map_size;
    public static int size = 2;
    public static int cx, cy, nx, ny;

    public static class Location implements Comparable<Location> {
        int loc_x;
        int loc_y;
        int weight;

        public Location(int loc_x, int loc_y, int weight) {
            this.loc_x = loc_x;
            this.loc_y = loc_y;
            this.weight = weight;
        }

        public int compareTo(Location o) {
            //*1. 거리비교 */
            if(this.weight != o.weight) {
                return Integer.compare(this.weight, o.weight);
            }
            //*만약에 거리가 같다면? 높이 비교*/
            if(this.loc_x != o.loc_x) {
                return Integer.compare(this.loc_x, o.loc_x);
            }

            //*만약 높이도 같다면? 좌 - 우 비교 */
                return Integer.compare(this.loc_y, o.loc_y);
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map_size = Integer.parseInt(br.readLine());

        map = new int[map_size][map_size];
        visited = new boolean[map_size][map_size];

        for(int i = 0; i < map_size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < map_size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 9) {
                    cx = i;
                    cy = j;
                    map[i][j] = 0;
                }
            }
        }

        bfs(cx, cy, 0);
    }

    public static void bfs(int cx, int cy, int dist) {

        Queue<Location> q = new LinkedList<>();

        //*시작점 방문 체크 */
        visited[cx][cy] = true;
        q.offer(new Location(cx, cy, dist));

        while(!q.isEmpty()) {
            Location current = q.poll();
            
            int cur_x = current.loc_x;
            int cur_y = current.loc_y;

            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx > 0 && nx <= map_size - 1 && ny > 0 && ny <= map_size - 1) {
                    if(!visited[nx][ny] && map[nx][ny] < size) {
                        
                    }
                }


            }
        }
        
        }
    };

