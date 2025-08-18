package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_Permutation {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean[] visited; //방문배열
    public static ArrayList<Integer> result; //결과 저장 배열

    public static void main(String[] args) throws IOException{
        //nPr
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        //값 입력
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열 초기화
        visited = new boolean[N + 1];
        result = new ArrayList<>();

        //순열 DFS
        Permutation(0, arr, R); //깊이, N, R
        
    }

    public static void Permutation(int depth, int[] arr, int R) {
        //기저 조건: R개를 모두 선택했으면 결과 출력
        if (depth == R) {
            System.out.println(result);
            return;
        }

        for(int i = 1; i< arr.length; i++) {
            if(!visited[i]) {
                //선택과정
                visited[i] = true;
                result.add(i);

                Permutation(depth + 1, arr, R);

                visited[i] = false;
                result.remove((result.size() - 1));
            }
        }
    }


}
