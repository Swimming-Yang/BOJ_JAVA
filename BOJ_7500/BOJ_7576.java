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
   public static boolean[][] visited;  // 방문 체크 배열
   public static int [][] graph;       // 토마토 상태 저장 배열

   public static void main(String[] args) throws IOException{

       // 입력: M(가로), N(세로) 순서
       st = new StringTokenizer(br.readLine());
       cols = Integer.parseInt(st.nextToken());  // M: 가로(열 개수)
       rows = Integer.parseInt(st.nextToken());  // N: 세로(행 개수)

       // 배열 초기화: N x M 크기
       visited = new boolean[rows][cols];
       graph = new int[rows][cols];

       // 토마토 상태 입력 받기
       // 0: 익지않음, 1: 익음, -1: 빈칸
       for(int i = 0; i < rows; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j < cols; j++) {
               graph[i][j] = Integer.parseInt(st.nextToken());
           }   
       }

       bfs();  // BFS 실행
   }

   public static void bfs() {
       // BFS를 위한 큐: {x좌표, y좌표, 날짜} 저장
       Queue<int[]> q = new ArrayDeque<>();
       int maxDay = 0;  // 최대 소요 일수 추적
       
       // 1단계: 처음에 익은 토마토들을 모두 큐에 넣기
       for(int i = 0; i < rows; i++) {
           for(int j = 0; j < cols; j++) {
               if(graph[i][j] == 1){  // 익은 토마토 발견
                   q.offer(new int[]{i, j, 0});  // 0일차에 이미 익음
                   visited[i][j] = true;  // 방문 처리
               }
           }
       }
       
       // 2단계: BFS로 토마토 익히기
       while(!q.isEmpty()) {
           // 현재 토마토 정보 가져오기
           int cur[] = q.poll();
           int cur_x = cur[0];    // 현재 x좌표
           int cur_y = cur[1];    // 현재 y좌표
           int cur_day = cur[2];  // 현재 날짜
           maxDay = cur_day;      // 최대 날짜 업데이트

           // 4방향으로 토마토 퍼뜨리기
           for(int i = 0; i < 4; i++) {
               int nx = cur_x + dx[i];  // 새로운 x좌표
               int ny = cur_y + dy[i];  // 새로운 y좌표

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
       
       // 3단계: 결과 확인
       // 익지 않은 토마토가 남아있는지 검사
       for(int i = 0; i < rows; i++) {
           for(int j = 0; j < cols; j++) {
               // 익지 않은 토마토이면서 방문하지 않은 경우
               if(graph[i][j] == 0 && !visited[i][j]) {
                   System.out.println(-1);  // 모든 토마토를 익힐 수 없음
                   return;
               }
           }
       }       
       
       // 모든 토마토가 익었으면 최대 소요 일수 출력
       System.out.println(maxDay);
   }
}