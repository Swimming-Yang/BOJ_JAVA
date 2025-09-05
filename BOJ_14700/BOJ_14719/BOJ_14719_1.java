package BOJ_14700.BOJ_14719;

import java.io.*;
import java.util.*;

public class BOJ_14719_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 각 열의 높이를 저장하는 1차원 배열
        int[] height = new int[W];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 각 열에 대해 물이 고일 수 있는 높이 계산
        for(int i = 1; i < W - 1; i++) {  // 양 끝은 물이 고일 수 없음
            
            // 왼쪽에서 가장 높은 벽 찾기
            int leftMax = 0;
            for(int left = 0; left < i; left++) {
                leftMax = Math.max(leftMax, height[left]);
            }

            // 오른쪽에서 가장 높은 벽 찾기
            int rightMax = 0;
            for(int right = i + 1; right < W; right++) {
                rightMax = Math.max(rightMax, height[right]);
            }

            // 물이 고일 수 있는 최대 높이 = 좌우 벽 중 낮은 것
            int waterLevel = Math.min(leftMax, rightMax);

            // 현재 위치의 벽보다 물 높이가 높으면 그 차이만큼 물이 고임
            if(waterLevel > height[i]) {
                answer += waterLevel - height[i];
            }
        }

        System.out.println(answer);
    }
}
