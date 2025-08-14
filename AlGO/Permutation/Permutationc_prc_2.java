package AlGO.Permutation;

import java.util.*;

public class Permutationc_prc_2 {
    static List<List<Integer>> result = new ArrayList<>();
    static boolean visited[];
    static List<Integer> current;

    public static void permutation(int[] arr, boolean[] visited, List<Integer> current, int r) {

        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(arr[i]);

                permutation(arr, visited, current, r);

                current.remove(current.size() -1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        visited = new boolean[arr.length];
        current = new ArrayList<>();

        permutatiton(arr, visited, current, r);

        for(List<Integer> perm : result) {
            for(int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }



}
