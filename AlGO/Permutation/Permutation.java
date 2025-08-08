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
    static void permutation(int n, int r) {
        if(stack.size() == r) { //
            for(int i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) { //n -> 3 r -> 2 
            if(!visited[i]) {
                visited[i] = true;
                stack.push(arr[i]);
                permutation(n, r);
                stack.pop();
                visited[i] = false;

            }
        }
    }

}
