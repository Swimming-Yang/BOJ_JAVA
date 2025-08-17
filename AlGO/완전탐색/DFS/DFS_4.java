/*
 * 조합, 순열 DFS
 * 
 */

package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_4 {

    public static boolean[] visited;
    public static ArrayList<Integer> result;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new ArrayList<>();

        System.out.println(N + "P" + R + "순열");
        Permutation(0, N, R);

        result.clear();

        System.out.println(N + "C" + R + "조합");
        Combination(0, 1, N, R);

    }

    public static void Permutation(int depth, int N, int R) {
        if (depth == R) {
            System.out.println(result);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]){
            //선택
            visited[i] = true;
            result.add(i);

            Permutation(depth + 1, N, R);
            //백트래킹
            visited[i] = false;
            result.remove(result.size() -1);
        }
    }
}

    public static void Combination(int depth, int start, int N, int R) {
        //종료조건
        if (depth == R) {
            System.out.println(result);
            return;
        }

        for(int i = start; i <= N; i++) {
            result.add(i);
            Combination(depth + 1, i + 1, N, R);

            result.remove(result.size() - 1);
        }
    }

}
