package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_Permutation {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static boolean[] visited; // 방문배열
    public static int[] result; // 결과 저장 배열 (고정 크기)
    public static int[] arr; // 원본 배열
    
    public static void main(String[] args) throws IOException {
        // nPr 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        // 배열 값 입력
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 초기화
        visited = new boolean[N]; // N개 원소에 대한 방문 체크
        result = new int[R]; // R개 선택 결과 저장
        
        // 순열 DFS 실행
        permutation(0, R);
    }
    
    /**
     * DFS를 이용한 순열 생성
     * @param depth 현재 선택한 원소의 개수
     * @param r 선택할 원소의 개수
     */
    public static void permutation(int depth, int r) {
        // 기저 조건: r개를 모두 선택했으면 결과 출력
        if (depth == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        
        // 모든 원소에 대해 시도
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                // 선택
                visited[i] = true;
                result[depth] = arr[i]; // 실제 값을 저장
                
                // 재귀 호출
                permutation(depth + 1, r);
                
                // 백트래킹 (선택 취소)
                visited[i] = false;
            }
        }
    }
}
