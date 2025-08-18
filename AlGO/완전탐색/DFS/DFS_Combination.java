package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_Combination {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer> result;
    //조합은 방문배열 필요 x


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        //값 입력
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = new ArrayList<>();

        Combination(0, 0, arr, R); //깊이, 시작인덱스, 배열, 선택할개수
    }

    public static void Combination(int depth, int start_index, int[] arr, int R) {
        //기저 조건 : R개를 모두 선택했으면 출력
        if (depth == R){
            System.out.println(result);
            return;
        }

        for(int i = start_index; i < arr.length; i++) {
            result.add(arr[i]);

            Combination(depth + 1, start_index + 1, arr, R);

            result.remove(result.size() - 1);
        }
    }

}
