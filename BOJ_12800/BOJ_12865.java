package BOJ_12800;

import java.io.*;
import java.util.*;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N + 1][2]; // 물품 정보를 저장할 2차원 배열 (무게, 가치)
        for(int i = 1; i <= N; i++) { // 1번부터 N번까지 물품 정보 입력받기
            st = new StringTokenizer(br.readLine()); // 각 물품의 정보를 담은 줄 읽기
            items[i][0] = Integer.parseInt(st.nextToken()); // i번째 물품의 무게 저장
            items[i][1] = Integer.parseInt(st.nextToken()); // i번째 물품의 가치 저장
        }

        int[][] dp = new int[N + 1][K + 1]; // DP 테이블: dp[i][j] = i번째까지 물품을 고려했을 때 무게 j 이하로 얻을 수 있는 최대 가치

        for(int i = 1; i <= N; i++) { // 1번째부터 N번째까지 물품을 차례로 고려
            for(int j = 1; j <= K; j++) { // 무게 1부터 K까지 모든 경우를 고려
                if(items[i][0] > j) { // 현재 물품의 무게가 현재 고려하는 무게 한도를 초과하는 경우
                    dp[i][j] = dp[i - 1][j]; // 현재 물품을 포함할 수 없으므로 이전 물품까지의 최대 가치를 그대로 가져옴
                } else { // 현재 물품을 포함할 수 있는 경우
                    dp[i][j] = Math.max( // 두 경우 중 최대값을 선택
                        dp[i - 1][j], // 현재 물품을 포함하지 않는 경우의 최대 가치
                        dp[i - 1][j - items[i][0]] + items[i][1] // 현재 물품을 포함하는 경우의 최대 가치
                    );
                }
            }
        }
        
        System.out.println(dp[N][K]); // 모든 물품을 고려했을 때 무게 K 이하로 얻을 수 있는 최대 가치 출력
    }
}