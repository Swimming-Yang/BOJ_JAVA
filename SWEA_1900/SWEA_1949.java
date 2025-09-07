//cspell:ignore SWEA
package SWEA_1900;

import java.io.*;
import java.util.*;

public class SWEA_1949 {
    static int n, k, high, max;
    static int[][] arr;
    static int[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int x = 1; x <= t; x++) {
            max = 0;
            high = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            arr = new int[n + 2][n + 2];
            visit = new int[n + 2][n + 2];
            
            // 지도 입력
            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    high = Math.max(high, arr[i][j]); // 가장 높은 봉우리 체크
                }
            }
            
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][j] == high) {
                        visit[i][j] = 1;
                        dfs(i,j,1,1);
                        visit[i][j] = 0;
                    }
                }
            }
            
            System.out.println("#" + x + " "+ max);
        }
    }
    
    public static void dfs(int x,int y,int count, int cut) {
        int cur = arr[x][y];
        
        for(int i = 0; i < 4; i++) {
            int next = arr[x + dx[i]][y + dy[i]];
            
            // 외곽이 아니고 방문하지 않았다면
            if(next != 0 && visit[x + dx[i]][y + dy[i]] == 0) {
                // 경사가 더 낮다면
                if(next < cur) {
                    visit[x + dx[i]][y + dy[i]] = 1;
                    dfs(x + dx[i], y + dy[i], count + 1,cut);
                    visit[x + dx[i]][y + dy[i]] = 0;
                }

                else if(cut == 1) {
                    for(int j = 1; j <= k; j++) {
                        if((next - j) < cur){
                            arr[x + dx[i]][y + dy[i]] -= j;
                            visit[x + dx[i]][y + dy[i]] = 1;
                            dfs(x + dx[i], y + dy[i], count + 1,cut - 1);
                            visit[x + dx[i]][y + dy[i]] = 0;
                            arr[x + dx[i]][y + dy[i]] += j;
                        }
                    }
                }
            }
        }
        
        if(count > max) {
            max = count;
        }
    }
}