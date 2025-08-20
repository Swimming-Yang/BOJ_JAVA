package AlGO.완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_Permutation_ArrayList {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer> result;
    public static ArrayList<Integer> arr;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        //nPr값 입력받기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //그래프 초기화
        result = new ArrayList<>();
        arr = new ArrayList<>();
        visited = new boolean[n];
        
        //arr에 값 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));  // add() 사용하고 값 입력
        }

        System.out.println("nPr 순열 결과:");
        permutation(0, r);
    }

    public static void permutation(int depth, int r) {
        //기저 조건
        if(depth == r) {
            System.out.println(result);
            return;
        }

        for(int i = 0; i < arr.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                result.add(arr.get(i));              // arr의 i번째 원소를 result에 추가
                
                permutation(depth + 1, r);          // 재귀 호출
                
                // 백트래킹: 상태 복원
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }  // <- 이 중괄호가 누락되어 있었습니다!
    }
}   