package AlGO.Permutation;

import java.util.*;

public class Permutation {
    static int[] arr;
    static boolean[] visited;
    static Stack<Integer> stack;
    public static void main(String[] args) {
        System.out.println("----순열 베이스코드----");
        stack = new Stack();
        arr = new int[] {1, 2, 3};
        visited = new boolean[3];
        permutation(3, 2);
    }

    //순열
    static void permutation(int n, int r) { //3개 중 2개
        if(stack.size() == r) { //선택을 이미 마쳤다면
            for(int i : stack) { //스택을 순회해서
                System.out.print(i + " "); // 출력
            }
            System.out.println(); //줄바꿈
            return;
        }

        for(int i = 0; i < n; i++) { //n -> 3 r -> 2  
            if(!visited[i]) { //방문체크
                visited[i] = true; //방문체크
                stack.push(arr[i]); //arr[i]를 스택에 푸시
                permutation(n, r); //재귀
                stack.pop();
                visited[i] = false; //초기화

            }
        }
    }

}
