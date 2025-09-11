//&BOJ_3차원 토마토

package BOJ_7500;

import java.io.*;
import java.util.*;

public class BOJ_7569 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    // 3차원 이동을 위한 방향 배열 (상하좌우앞뒤)
    public static int[] dx = {0, 0, 1, -1, 0, 0};  // x축
    public static int[] dy = {1, -1, 0, 0, 0, 0};  // y축 
    public static int[] dz = {0, 0, 0, 0, 1, -1};  // z축
    
    public static int cols, rows, height;
    public static boolean[][][] visited;
    public static int[][][] graph;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        cols = Integer.parseInt(st.nextToken());
        rows = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        
        visited = new boolean[height][rows][cols];
        graph = new int[height][rows][cols];
        
        // 3차원 배열 입력 (H개의 2차원 배열)
        for(int h = 0; h < height; h++) {
            for(int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < cols; j++) {
                    graph[h][i][j] = Integer.parseInt(st.nextToken());
                }   
            }
        }
        
        bfs();
    }
    
    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int maxDay = 0;
        
        // 모든 익은 토마토를 큐에 추가 (시작점들)
        for(int h = 0; h < height; h++) {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(graph[h][i][j] == 1){
                        q.offer(new int[]{h, i, j, 0});  // {높이, 행, 열, 날짜}
                        visited[h][i][j] = true;
                    }
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_h = cur[0];  // 현재 높이
            int cur_x = cur[1];  // 현재 행
            int cur_y = cur[2];  // 현재 열
            int cur_day = cur[3]; // 현재 날짜
            maxDay = cur_day;
            
            // 6방향으로 이동 (상하좌우앞뒤)
            for(int i = 0; i < 6; i++) {
                int nh = cur_h + dz[i];  // 새로운 높이
                int nx = cur_x + dx[i];  // 새로운 행
                int ny = cur_y + dy[i];  // 새로운 열
                
                // 범위 체크 (3차원)
                if(nh >= 0 && nh < height && nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    // 방문하지 않았고 익지 않은 토마토인 경우
                    if(!visited[nh][nx][ny] && graph[nh][nx][ny] == 0) {
                        q.offer(new int[]{nh, nx, ny, cur_day + 1});  // 다음 날 익음
                        visited[nh][nx][ny] = true;  // 방문 처리
                    }
                }
            }
        }
        
        // 익지 않은 토마토가 남아있는지 검사
        for(int h = 0; h < height; h++) {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    // 익지 않은 토마토이면서 방문하지 않은 경우
                    if(graph[h][i][j] == 0 && !visited[h][i][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(maxDay);
    }
}
