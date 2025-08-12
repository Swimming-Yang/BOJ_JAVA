package AlGO.Subset;

import java.util.*;

public class Subset {
    static List<List<Integer>> result = new ArrayList<>();
    
    // 부분집합 생성 함수
    // arr: 부분집합을 만들 원소들의 배열
    // index: 현재 고려중인 원소의 인덱스
    // current: 현재까지 선택된 원소들
    public static void subset(int[] arr, int index, List<Integer> current) {
        
        // 기저 조건: 모든 원소를 고려했을 때
        // (조합/순열과 다르게 개수 제한 없음!)
        if (index == arr.length) {
            // 현재까지 선택된 원소들을 부분집합으로 저장
            result.add(new ArrayList<>(current));
            return;
        }
        
        // 선택지 1: 현재 원소를 선택하지 않는 경우
        subset(arr, index + 1, current);
        
        // 선택지 2: 현재 원소를 선택하는 경우  
        current.add(arr[index]);           // 현재 원소 추가
        subset(arr, index + 1, current);  // 다음 원소 고려
        current.remove(current.size() - 1); // 백트래킹
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> current = new ArrayList<>();
        
        System.out.println("=== [1,2,3]의 모든 부분집합 ===");
        subset(arr, 0, current);
        
        for (List<Integer> sub : result) {
            System.out.println(sub);
        }
        /* 출력:
         * []
         * [3]  
         * [2]
         * [2, 3]
         * [1]
         * [1, 3] 
         * [1, 2]
         * [1, 2, 3]
         */
    }
}
