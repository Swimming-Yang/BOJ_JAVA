package BOJ_15600.BOJ_15650;

import java.io.*;
import java.util.*;

public class BOJ_15650_2 {

    public static int N;                      // 선택 배열범위 (1~N)
    public static int R;                      // 선택할 개수
    public static int[] current;              // 현재 조합
    // public static boolean[] visited;       // 조합에서는 visited 배열 불필요!
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 배열의 길이는?
        R = Integer.parseInt(st.nextToken());   // 몇개를 선택?

        current = new int[R];                   // 현재 배열 초기화
        // visited = new boolean[N];            // 조합에서는 필요 없음

        dfs(0, 1);                              // 깊이 0, 시작 인덱스 1부터 dfs 시작 
        System.out.print(sb);                   // 마지막 개행 제거를 위해 print 사용
    }

    public static void dfs(int depth, int start) {
        // 기저 조건: R개를 모두 선택했을 때
        if(depth == R) {
            for(int i = 0; i < current.length; i++) {
                sb.append(current[i]);
                if(i < current.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append('\n');
            return;
        }

        // start부터 N까지 모든 숫자에 대해 시도 (중복 방지)
        for(int i = start; i <= N; i++) {
            current[depth] = i;                 // 현재 숫자를 조합에 추가
            dfs(depth + 1, i + 1);              // 다음 깊이로 재귀 (i+1부터 시작)
            // 백트래킹이 자동으로 됨 (배열 덮어쓰기)
        }
    }
}