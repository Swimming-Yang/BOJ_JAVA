package AlGO.Combination;

import java.util.*;

public class Combination_prc {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> current;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; //조합 할 배열
        List<Integer> current = new ArrayList<>();

        combination(arr, 0, current, 2);

        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
        
    }

    public static void combination(int[] arr, int start, List<Integer> current, int r) {

        //숫자 선택을 마쳤을 때
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < arr.length; i++ ) {
            current.add(arr[i]);

            combination(arr, i + 1, current, r);

            current.remove(current.size() - 1);
        }
    }

}
