package AlGO.Subset;

import java.util.*;

public class subSet_prc {
    static List<List<Integer>> result = new ArrayList<>();


    public static void generateSubsets(int[] arr, int index, List<Integer> current) {
        //기저조건: 모든 원소에 대한 결정 완료
        if(index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        //1. 현재 원소를 포함하지 않음.
        generateSubsets(arr, index + 1, current);

        //2. 현재 원소 포함
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current);
        

        //리턴하는 위치
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        generateSubsets(arr, 0, new ArrayList<>());

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

}
