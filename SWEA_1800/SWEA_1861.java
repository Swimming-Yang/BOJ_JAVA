//cspell:ignore SWEA
//SWEA_1861_정사각형 방

//완전탐색 + 

package SWEA_1800;

import java.io.*;
import java.util.*;

public class SWEA_1861 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int room_size, max_room, room_num;
    public static int[][] map;
    public static boolean [][] visited;


    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 1; i < testcase_num + 1; i++) {
            room_size = Integer.parseInt(br.readLine());
            
            //배열 초기화
            map = new int[room_size][room_size];
            visited = new boolean[room_size][room_size];
            max_room = 0;                   //초기화 위치 잘찾아야 함.
            room_num = Integer.MAX_VALUE;

            //배열에 값 입력
            for(int j = 0; j < room_size; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k <room_size; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());

                }
            }

            for(int j = 0; j < room_size; j++) {
                for(int k = 0; k < room_size; k++) {
                    visited = new boolean[room_size][room_size]; // 탐색마다 방문배열 초기화
                    bfs(j, k);

                    
                }
            }
            System.out.println("#" + i + " " + room_num + " " + max_room);
        }

        
    }
    /*
     * 탐색 조건
     * 1. 사방탐색을 하되, 방의 번호의 차이가 +1 이어야 함.
     * 
     */

    public static void bfs(int start_x, int start_y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_x, start_y});
        visited[start_x][start_y] = true; //방문배열 갱신
        int count = 1;

        while(!q.isEmpty()) { //큐가 빌 때 까지 반복
            int node[] = q.poll();
            int cur_x = node[0];
            int cur_y = node[1];

            for(int i =0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && nx < room_size && ny >= 0 && ny < room_size) {
                    if (!visited[nx][ny] && map[nx][ny] == map[cur_x][cur_y] + 1) {
                        count++;
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if(count > max_room) {
            max_room = count;{
            room_num = map[start_x][start_y];
            }
        } else if(count == max_room && room_num > map[start_x][start_y]){
            room_num = map[start_x][start_y];
        }

    }
}
