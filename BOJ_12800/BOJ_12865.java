package BOJ_12800;

import java.io.*;
import java.util.*;

public class BOJ_12865 {
    static int N;        // 물품의 개수
    static int limit;    // 배낭의 무게 제한
    static int[] weight; // 각 물품의 무게
    static int[] value;  // 각 물품의 가치
    static int[][] dp;   // DP 테이블

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());          // 물품 개수 저장
        limit = Integer.parseInt(st.nextToken());      // 무게 제한 저장

        // 배열 초기화 (1부터 N까지 사용하기 위해 크기 N+1)
        weight = new int[N+1];  // 무게 배열
        value = new int[N+1];   // 가치 배열

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());  // 무게 읽기
            int V = Integer.parseInt(st.nextToken());  // 가치 읽기
            weight[i] = W;  // i번째 물품의 무게 저장
            value[i] = V;   // i번째 물품의 가치 저장
        }

        // DP 테이블 초기화 (물품 개수 × 무게 제한)
        dp = new int[N+1][limit+1];

        // DP 테이블 채우기 (물품 1번부터 N번까지)
        for(int i = 1; i < N + 1; i++) {
            // 무게 제한 1부터 limit까지
            for(int j = 1; j < limit + 1; j++) {
                // 이전 물품까지의 최적해를 일단 가져옴
                dp[i][j] = dp[i-1][j];
                
                // i번째 물품을 넣을 수 있다면 (무게가 허용 범위 내)
                if(weight[i] <= j) {
                    // 현재 최적해 vs (i번째 물품을 넣었을 때의 가치) 중 최대값
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 최종 답 출력 (N개 물품, 무게 제한 limit일 때의 최대 가치)
        System.out.println(dp[N][limit]);
    }
}