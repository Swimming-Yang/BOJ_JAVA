//&BOJ_16236_아기상어

package BOJ_16200;

import java.io.*;
import java.util.*;

public class BOJ_16236 {

    //*탐색배열 위쪽 상 -> 왼 -> 하 -> 오 */
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};

    public static int[][] map;
    public static boolean[][] visited;


    public static int map_size;
    public static int size = 2;
    public static int cx, cy;
    public static int eatCount = 0;

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
        
        int totalTime = 0;
        
        while(true) {
            visited = new boolean[map_size][map_size];  // 매번 초기화
            Location target = bfs(cx, cy, 0);
            
            if(target == null) {
                // 더 이상 먹을 물고기가 없으면 게임 종료
                break;
            }
            
            // 물고기를 먹었다면
            totalTime += target.weight;      // 시간 누적
            cx = target.loc_x;               // 상어 위치 업데이트
            cy = target.loc_y;
            map[cx][cy] = 0;                 // 먹은 물고기 제거
            
            // 상어 크기 업데이트
            eatCount++;
            if(eatCount == size) {
                size++;
                eatCount = 0;
            }
        }
        
        System.out.println(totalTime);
    }

    public static Location bfs(int cx, int cy, int dist) {

        Queue<Location> q = new LinkedList<>();
        PriorityQueue<Location> pq = new PriorityQueue<>();

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

                if(nx >= 0 && nx < map_size && ny >= 0 && ny < map_size) {
                    if(!visited[nx][ny] && map[nx][ny] <= size) {
                        visited[nx][ny] = true;
                        q.offer(new Location(nx, ny, current.weight + 1));
                        
                        if(map[nx][ny] > 0 && map[nx][ny] < size) {
                            pq.add(new Location(nx, ny, current.weight + 1));
                        }
                    }
                }
            }
        }
        
        if(!pq.isEmpty()) {
            return pq.poll();
        }
        else {
            return null;
        }
    }
};