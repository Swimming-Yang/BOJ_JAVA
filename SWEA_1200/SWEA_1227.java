//cspell:ignore SWEA
//SWEA_1227 미로2
package SWEA_1200;

import java.io.*;
import java.util.*;

public class SWEA_1227 {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};
    
    public static String[][] graph = new String[100][100];
    public static boolean[][] visited;
    public static boolean answer;
    
    public static void main(String[] args) throws IOException{
        
        for(int testcase = 1; testcase <= 10; testcase++) {
            
            // 초기화
            answer = false;
            int start_x = 0, start_y = 0;
            visited = new boolean[100][100];
            
            for(int i = 0; i < 100; i++) {
                String line = br.readLine();
                for(int j = 0; j < 100; j++) {
                    graph[i][j] = String.valueOf(line.charAt(j));
                    // 시작점 찾기 -> 2
                    if(graph[i][j].equals("2")) {
                        start_x = i;
                        start_y = j;
                    }
                }
            }
            
            dfs(start_x, start_y);
            
            System.out.print("#" + testcase + " ");
            if(answer) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    
    public static void dfs(int x, int y) {
        if(graph[x][y].equals("3")) {
            answer = true;
            return;
        }
        
        //방문배열 갱신
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
                continue;
            }
            if(answer) {
                return;
            }
            if(!visited[nx][ny] && !graph[nx][ny].equals("1")) {
                dfs(nx, ny);
            }
        }
    }
}