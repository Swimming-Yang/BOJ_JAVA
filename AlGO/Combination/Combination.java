package AlGO.Combination;

import java.util.*;

public class Combination {

    static int[] arr;            // 조합을 뽑을 원소들이 들어있는 배열
    static boolean[] visited;    // 해당 원소를 이미 선택했는지 표시
    static Stack<Integer> stack; // 현재 선택된 원소들을 담는 스택 (순서 유지)

    public static void main(String[] args) {
        System.out.println("---- 조합 ----");
        
        stack = new Stack<>();         // 스택 초기화
        arr = new int[] {1, 2, 3};     // 뽑을 대상 배열
        visited = new boolean[3];      // 방문 여부 체크 배열

        // combination(시작 인덱스, 뽑을 개수)
        combination(0, 2);             // arr에서 길이 2짜리 조합을 구함
    }

    // idx: 탐색 시작 인덱스
    // r: 뽑아야 하는 개수
    static void combination(int idx, int r) {
        // ===== 기저 조건 =====
        if(stack.size() == r) { // r개를 모두 뽑았다면
            for(int i : stack) {
                System.out.print(i + " "); // 현재 스택의 내용 출력
            }
            System.out.println(); // 한 줄 띄우기
            return;               // 이 경로 종료
        }

        // ===== 재귀 탐색 =====
        for(int i = idx; i < arr.length; i++) { 
            // i를 idx부터 시작 → 이전에 선택한 원소보다 앞의 원소는 건너뜀 (조합의 핵심)

            if(!visited[i]) {       // 아직 선택하지 않은 원소라면
                visited[i] = true;  // 선택 표시
                stack.push(arr[i]); // 스택에 해당 원소 추가

                // 다음 탐색은 현재 i 이후부터 (중복 방지)
                combination(i + 1, r);

                // ===== 백트래킹 =====
                stack.pop();        // 마지막에 넣은 원소 제거
                visited[i] = false; // 방문 여부 원상 복구
            }
        }
    }
}
