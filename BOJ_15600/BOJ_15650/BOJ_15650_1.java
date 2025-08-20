package BOJ_15600.BOJ_15650;

import java.io.*;
import java.util.*;

public class BOJ_15650_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        combination(1, 0, N, M);
    }

    public static void combination(int start, int depth, int N, int M) {
        if(depth == M) {
            // 선택된 숫자들을 하나씩 출력
            for(int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                // 마지막 숫자가 아니라면 공백 출력
                if(i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
            // 한 조합 출력 완료 후 줄바꿈
            System.out.println();
            return;
        }

        // start부터 N까지의 모든 숫자에 대해 반복
        for(int i = start; i <= N; i++) {
            // 현재 숫자 i를 결과 리스트에 추가
            result.add(i);
            // 재귀 호출: 다음 숫자(i+1)부터, 깊이+1, 오름차순 보장
            combination(i + 1, depth + 1, N, M);
            // 백트래킹: 방금 추가한 숫자를 제거 (다른 경우의 수 탐색)
            result.remove(result.size() - 1);
        }
    }
}