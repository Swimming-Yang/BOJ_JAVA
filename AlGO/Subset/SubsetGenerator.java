package AlGO.Subset;
import java.util.*;

public class SubsetGenerator {
    static List<List<Integer>> result = new ArrayList<>();
    
    // 각 원소마다 "포함할까? 말까?" 결정하는 재귀
    public static void generateSubsets(int[] arr, int index, List<Integer> current) {
        // 🎯 기저 조건: 모든 원소에 대한 결정 완료
        if (index == arr.length) {
            result.add(new ArrayList<>(current));  // 현재 부분집합 저장
            return;
        }
        
        // 🔹 선택지 1: 현재 원소를 포함하지 않음
        generateSubsets(arr, index + 1, current);
        
        // 🔹 선택지 2: 현재 원소를 포함함
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current);
        current.remove(current.size() - 1);  // 백트래킹
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generateSubsets(arr, 0, new ArrayList<>());
        
        System.out.println("모든 부분집합:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        
        System.out.println("총 개수: " + result.size());
    }
}