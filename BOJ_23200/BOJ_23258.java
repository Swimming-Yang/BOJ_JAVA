//&BOJ_23258_밤편지

package BOJ_23200;

import java.io.*;
import java.util.*;

public class BOJ_23258 {

    public static int[][][] dist;
    public static int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1][N + 1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                // 모든 k에 대해 초기값 설정
                for(int k = 0; k <= N; k++) {
                    if(i == j) {
                        dist[k][i][j] = 0;
                    } else if(weight == 0) {
                        dist[k][i][j] = INF;  //*연결x
                    } else {
                        dist[k][i][j] = weight;
                    }
                }
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    dist[k][i][j] = dist[k-1][i][j];
                    
                    // k번 집을 새로 경유하는 경우와 비교
                    if(dist[k-1][i][k] != INF && dist[k-1][k][j] != INF) {
                        dist[k][i][j] = Math.min(dist[k][i][j], dist[k-1][i][k] + dist[k-1][k][j]);
                    }
                }
            }
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());  // 이슬 한계
            int s = Integer.parseInt(st.nextToken());  // 출발
            int e = Integer.parseInt(st.nextToken());  // 도착
            
            if(dist[C][s][e] == INF) {
                System.out.println(-1); //연결 안됨
            } else {
                System.out.println(dist[C][s][e]);
            }
        }
    }
}