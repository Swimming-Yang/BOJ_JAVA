//BOJ_1068 트리

package BOJ_1000;

import java.io.*;
import java.util.*;

public class BOJ_1068 {

    static boolean visited[]; //방문 배열
    static List<Integer> tree[];
    static int cnt = 0;
    static int N;
    static int remove;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //노드의 개수

        visited = new boolean[N]; //방문기록 초기화
        tree = new ArrayList[N];
        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }
        int root = 0; //루트 노드 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int p = Integer.parseInt(st.nextToken());
            if(p!=-1){
                tree[p].add(i);
            }
            else{
                root = i;
            }
        }
        
        remove = Integer.parseInt(br.readLine());
        //
        if(remove == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(cnt);
        }
    }


    static void dfs(int n){ //dfs탐색
        visited[n] = true;
        int child = 0;
        for(int i:tree[n]) {
            if(i != remove && !visited[i]) {
                child++;
                dfs(i);
            }
        }

        if(child == 0) {
            cnt++;
        }
    }
}
