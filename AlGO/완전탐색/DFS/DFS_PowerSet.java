package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_PowerSet {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException{
        //배열의 개수
        int N = Integer.parseInt(br.readLine());
        
        result = new ArrayList<>();
        int[] arr = new int[N];

        //배열 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("배열의 모든 부분집합");
        PowerSet(0, arr); //시작인덱스, 배열
        
    }

    public static void PowerSet(int start_index, int[] arr) {
        if (start_index >= arr.length) {
            System.out.println(result);
            return;
        }

        //1. 현재 원소를 포함하지 않는 경우
        PowerSet(start_index + 1, arr);

        //2. 현재 원소를 포함하는 경우.
        result.add(arr[start_index]);
        PowerSet(start_index + 1, arr);

        result.remove(result.size() - 1);

    }

}
