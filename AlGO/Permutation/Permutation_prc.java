package AlGO.Permutation;

import java.util.*;

public class Permutation_prc {
    static List<List<Integer>> result = new ArrayList<>();
    static boolean visited[];
    static List<Integer> current;

    public static void permutation(int[] arr, boolean[] visited, List<Integer> current, int r) {
        //조건만족 -> 배열이 r만큼 채워졌다면

        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        //조건 불만족 -> 아직 배열이 r만큼 채워지지 않음
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) { //만약 원소를 아직 사용하지 않았다면
                visited[i] = true; //방문배열 갱신
                current.add(arr[i]);

                permutation(arr, visited, current, r);

                //리턴 복귀 위치
                current.remove(current.size() - 1);
                visited[i] = false;
            }

        }
    }

    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // 순열을 진행 할 배열 생성
        visited = new boolean[arr.length]; //순서가 중요하니 방문배열 생성
        current = new ArrayList<>(); //현재 경우의 수를 담을 배열


        permutation(arr, visited, current, 2);  //순열진행배열, 방문배열, 현재배열, 뽑을개수

        for(List<Integer> perm : result) {
            System.out.println(perm);
        }
    }



}
