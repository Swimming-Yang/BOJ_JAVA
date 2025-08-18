
/*
 * 2차원 격자 기반 DFS
 * 
 */

package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_2 {

    public static int[][] map;
    public static boolean[][] visited;
    
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int rows, cols;//가로줄, 세로줄
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        
        //그래프 초기화
        map = new int[rows][cols];
        visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true; //방문처리
        System.out.println("방문처리 된 노드 = x : " + x + "y : " + y);

        //4방 탐색
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
        
        //조건확인 + 방문체크
            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    dfs(nx, ny);
                    
                }
            }
        
        }
    }

}
