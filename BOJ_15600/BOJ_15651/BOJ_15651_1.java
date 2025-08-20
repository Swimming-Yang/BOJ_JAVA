package BOJ_15600.BOJ_15651;

import java.io.*;
import java.util.*;

public class BOJ_15651_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static ArrayList<Integer> result;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
        
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
                
        permutation(0, N, M);
        System.out.print(sb.toString());
    }

    public static void permutation(int depth, int N, int M) {
        // 기저조건: M개의 숫자를 모두 선택했다면
        if(depth == M) {
            for(int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
                if(i < result.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            result.add(arr[i]);
            permutation(depth + 1, N, M);
            result.remove(result.size() - 1);
        }
    }
}