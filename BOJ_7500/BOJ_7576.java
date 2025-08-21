package BOJ_7500;

import java.io.*;
import java.util.*;

public class BOJ_7576 {

   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static StringTokenizer st;

   // 상하좌우 이동을 위한 방향 배열
   public static int[] dx = {0, 1, 0, -1};
   public static int[] dy = {1, 0, -1, 0};

   public static int rows, cols;
   public static boolean[][] visited;
   public static int [][] graph;

   public static void main(String[] args) throws IOException{

       st = new StringTokenizer(br.readLine());
       cols = Integer.parseInt(st.nextToken());  // M: 가로(열 개수)
       rows = Integer.parseInt(st.nextToken());  // N: 세로(행 개수)

       // 배열 초기화
       visited = new boolean[rows][cols];
       graph = new int[rows][cols];


       for(int i = 0; i < rows; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j < cols; j++) {
               graph[i][j] = Integer.parseInt(st.nextToken());
           }   
       }

       bfs();
   }

   public static void bfs() {

       Queue<int[]> q = new ArrayDeque<>();
       int maxDay = 0;
       
       for(int i = 0; i < rows; i++) {
           for(int j = 0; j < cols; j++) {
               if(graph[i][j] == 1){
                   q.offer(new int[]{i, j, 0});
                   visited[i][j] = true;
               }
           }
       }
       
       while(!q.isEmpty()) {
           int cur[] = q.poll();
           int cur_x = cur[0];
           int cur_y = cur[1];
           int cur_day = cur[2];
           maxDay = cur_day;


           for(int i = 0; i < 4; i++) {
               int nx = cur_x + dx[i];
               int ny = cur_y + dy[i];

               // 범위 체크
               if(nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                   // 방문하지 않았고 익지 않은 토마토인 경우
                   if(!visited[nx][ny] && graph[nx][ny] == 0) {
                       q.offer(new int[]{nx, ny, cur_day + 1});  // 다음 날 익음
                       visited[nx][ny] = true;  // 방문 처리
                   }
               }
           }
       }
       
       // 익지 않은 토마토가 남아있는지 검사
       for(int i = 0; i < rows; i++) {
           for(int j = 0; j < cols; j++) {
               // 익지 않은 토마토이면서 방문하지 않은 경우
               if(graph[i][j] == 0 && !visited[i][j]) {
                   System.out.println(-1);
                   return;
               }
           }
       }       
       System.out.println(maxDay);
   }
}