package AlGO.Combination;

import java.util.*;

public class Combination {
    static List<List<Integer>> result = new ArrayList<>();
    
    // 조합 생성 함수
    // arr: 조합을 만들 원소들의 배열
    // start: 현재 탐색 시작 인덱스 ⭐ (핵심 변화!)
    // current: 현재까지 선택된 원소들
    // r: 선택할 원소의 개수
    public static void combination(int[] arr, int start, List<Integer> current, int r) {
        
        // 기저 조건: r개를 모두 선택했을 때
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // ⭐ 핵심 변화: i를 start부터 시작 (이전 원소들은 다시 보지 않음)
        for (int i = start; i < arr.length; i++) {
            // visited 배열 필요 없음! (어차피 이전 원소는 안봄)
            current.add(arr[i]);      // 현재 원소 선택
            
            // ⭐ 다음 재귀에서는 i+1부터 시작 (현재 선택한 원소 이후부터)
            combination(arr, i + 1, current, r);  
            
            current.remove(current.size() - 1);  // 백트래킹
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> current = new ArrayList<>();
        
        System.out.println("조합연습");
        combination(arr, 0, current, 2);  // start=0부터 시작
        
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}