package AlGO.Permutation;

import java.util.*;

public class Permutation {
    static List<List<Integer>> result = new ArrayList<>();

    public static void permutation(int [] arr, boolean[] visited, List<Integer> current, int r) {
        //조건 만족
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }


        //조건 불만족
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) { //원소를 아직 사용하지 않았다면
                visited[i] = true; //방문배열 갱신
                current.add(arr[i]); //사용하지 않은 숫자 넣기

                permutation(arr, visited, current, r); //재귀 호출

                //리턴하면 돌아오는 구간
                current.remove(current.size() - 1); //백트레킹
                visited[i] = false; //사용 표시 해제
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] visited = new boolean[arr.length];
        List<Integer> current = new ArrayList<>();

        System.out.println("순열연습");
        permutation(arr, visited, current, 2);
 
        for(List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}


