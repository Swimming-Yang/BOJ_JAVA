//BOJ_1717_집합의 표현

package BOJ_1700;

import java.io.*;
import java.util.*;

public class BOJ_1717 {  // 클래스명은 그대로 유지 (파일명과 일치해야 함)

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N;
    public static int M;

    public static int[] parent;
    public static int[] height;  // Union by Height 최적화 추가

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        height = new int[N + 1];
        
        // 🔧 수정: N+1까지 초기화 (0번 인덱스부터 N번까지)
        for(int i = 0; i <= N; i++) {  // <= N으로 변경
            parent[i] = i;
            height[i] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                union(a, b);  // 함수명 변경
            } else if(command == 1) {
                if(find(a) == find(b)) {  // 함수명 변경
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // Path Compression을 적용한 Find
    public static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);  // Path Compression
    }

    // Union by Height를 적용한 Union
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return;  // 이미 같은 집합
        }

        // Union by Height: 높이가 낮은 트리를 높은 트리 아래에 붙이기
        if(height[rootA] < height[rootB]) {
            parent[rootA] = rootB;
        } else if(height[rootA] > height[rootB]) {
            parent[rootB] = rootA;
        } else {
            // 같은 높이면 한쪽을 다른 쪽 아래에 붙이고 높이 증가
            parent[rootB] = rootA;
            height[rootA]++;
        }
    }
}

/* 
문제 해결 포인트:
1. 패키지명과 클래스명 불일치는 VS Code 설정 문제일 수 있음
2. 배열 초기화 범위 수정: i <= N
3. Union by Height로 최적화
4. 함수명을 더 명확하게 변경
*/