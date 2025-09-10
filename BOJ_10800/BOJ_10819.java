//&BOJ_10819_차이를 최대로

package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10819 {

    public static int[] arr;
    public static boolean[] visited;
    public static int[] current;
    public static int maxDifference = 0; // 최대 차이의 합을 저장할 변수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 전역 변수 초기화
        visited = new boolean[N];
        current = new int[N];
        
        // 순열 생성 시작
        Permutation(0);
        
        // 결과 출력
        System.out.println(maxDifference);
    }

    public static void Permutation(int depth) {
        // 기저 조건: 모든 원소를 선택했을 때
        if(depth == current.length) {
            Calculation(current);
            return;
        }
        
        // 모든 원소에 대해 시도
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = arr[i];
                Permutation(depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    public static void Calculation(int[] current) {
        int sum = 0;
        
        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[n-2] - A[n-1]| 계산
        for(int i = 0; i < current.length - 1; i++) {
            sum += Math.abs(current[i] - current[i + 1]);
        }
        
        // 최대값 갱신
        maxDifference = Math.max(maxDifference, sum);
    }
}