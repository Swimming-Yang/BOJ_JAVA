package BOJ_2600;

import java.io.*;
import java.util.*;

public class BOJ_2617 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int INF = 100_000_000;
        int[][] floyd = new int[N + 1][N + 1];
        
        // 플로이드 워셜 초기화
        for(int i = 1; i <= N; i++) {
            Arrays.fill(floyd[i], INF);
            floyd[i][i] = 0;
        }
        
        // 간선 입력
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            floyd[to][from] = 1;
        }
        
        // 플로이드 워셜
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }
        

        int ans = 0;
        int limit = (N + 1) / 2;
        
        for(int i = 1; i <= N; i++) {
            int high = 0;
            int low = 0;
            for(int j = 1; j <= N; j++) {
                if(floyd[i][j] != INF && floyd[i][j] > 0) high += 1;
                else if(floyd[j][i] != INF && floyd[j][i] > 0) low += 1;
            }
            if(high >= limit || low >= limit) ans += 1;
        }
        
        System.out.println(ans);
    }
}
