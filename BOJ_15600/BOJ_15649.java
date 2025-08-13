//BOJ_15649 N과M(1)
package BOJ_15600;

import java.io.*;
import java.util.*;

public class BOJ_15649 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> current;
    static int[] arr;
    static boolean[] visited;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        current = new ArrayList<>();

        for(int i = 1; i <= N; i ++) {
            arr[i - 1] = i;
        }

        Permutation(arr, visited, current, R);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            List<Integer> perm = result.get(i);
            for(int j = 0; j < perm.size(); j++) {
                sb.append(perm.get(j));
                if(j < perm.size() - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    public static void Permutation(int[] arr, boolean[] visited, List<Integer> current, int R) {
        //기저 조건
        if(current.size() == R) {
            result.add(new ArrayList<>(current));  // LinkedList 대신 ArrayList
            return;
        }
        //선택할 것이 남았을 때
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(arr[i]);

                Permutation(arr, visited, current, R);

                //백트레킹
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}