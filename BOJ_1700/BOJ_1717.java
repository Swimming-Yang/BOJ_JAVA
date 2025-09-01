//BOJ_1717_집합의 표현

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1717 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N;  // 집합의 개수 (0 ~ N)
    public static int M;  // 연산의 개수

    public static int[] parent;  // 각 원소의 부모를 저장하는 배열
    public static int[] height;  // 각 트리의 높이를 저장하는 배열

    public static void main(String[] args) throws IOException{
        /*
         * 의사코드:
         * 1. N, M 입력받기
         * 2. parent, height 배열 초기화 (Make-Set 연산)
         * 3. M번 반복:
         *    - command, a, b 입력받기
         *    - command가 0이면 Union(a, b)
         *    - command가 1이면 Find(a) == Find(b) 확인 후 결과 출력
         */
        
        // 1. 입력: 집합 개수 N, 연산 개수 M
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 배열 초기화
        parent = new int[N + 1];  // 0번부터 N번까지 사용
        height = new int[N + 1];
        
        // 3. Make-Set: 각 원소를 자기 자신을 루트로 하는 집합으로 초기화
        for(int i = 0; i <= N; i++) {
            parent[i] = i;    // 자기 자신이 부모 (루트)
            height[i] = 0;    // 초기 높이는 0
        }

        // 4. M개의 연산 처리
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());  // 연산 종류
            int a = Integer.parseInt(st.nextToken());        // 첫 번째 원소
            int b = Integer.parseInt(st.nextToken());        // 두 번째 원소

            if(command == 0) {
                // Union 연산: a와 b가 속한 집합을 합치기
                union(a, b);
            } else if(command == 1) {
                // Find 연산: a와 b가 같은 집합에 속하는지 확인
                if(findSet(a) == findSet(b)) {
                    System.out.println("YES");  // 같은 집합
                } else {
                    System.out.println("NO");   // 다른 집합
                }
            }
        }
    }

    /**
     * Find 연산: Path Compression 적용
     * 의사코드:
     * IF parent[x] == x THEN
     *     RETURN x  // 루트 노드
     * ELSE
     *     parent[x] ← Find(parent[x])  // Path Compression
     *     RETURN parent[x]
     * END IF
     */
    public static int findSet(int x) {
        // Base case: 자기 자신이 루트인 경우
        if(x == parent[x]) {
            return x;
        }
        // Recursive case: Path Compression으로 루트를 직접 연결
        return parent[x] = findSet(parent[x]);
    }

    /**
     * Union 연산: Union by Height 적용
     * 의사코드:
     * rootA ← Find(a)
     * rootB ← Find(b)
     * 
     * IF rootA == rootB THEN
     *     RETURN  // 이미 같은 집합
     * END IF
     * 
     * IF height[rootA] < height[rootB] THEN
     *     parent[rootA] ← rootB  // A트리를 B트리 아래에 붙이기
     * ELSE IF height[rootA] > height[rootB] THEN
     *     parent[rootB] ← rootA  // B트리를 A트리 아래에 붙이기
     * ELSE
     *     parent[rootB] ← rootA  // 같은 높이면 한쪽을 다른쪽 아래에 붙이고
     *     height[rootA] ← height[rootA] + 1  // 높이 증가
     * END IF
     */
    public static void union(int a, int b) {
        // 1단계: 각 원소의 루트 찾기
        int rootA = findSet(a);
        int rootB = findSet(b);

        // 2단계: 이미 같은 집합인지 확인
        if(rootA == rootB) {
            return;  // 같은 집합이면 합칠 필요 없음
        }

        // 3단계: Union by Height - 높이가 낮은 트리를 높은 트리 아래에 붙이기
        if(height[rootA] < height[rootB]) {
            // A트리가 더 낮음 → A를 B 아래에 붙이기
            parent[rootA] = rootB;
        } else if(height[rootA] > height[rootB]) {
            // B트리가 더 낮음 → B를 A 아래에 붙이기
            parent[rootB] = rootA;
        } else {
            // 같은 높이 → B를 A 아래에 붙이고 A의 높이 1 증가
            parent[rootB] = rootA;
            height[rootA]++;
        }
    }
}