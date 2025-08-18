//DFS_인접리스트 기반 (그래프/트리)

package AlGO.완전탐색.DFS;

import java.io.*;
import java.util.*;

public class DFS_1 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void dfs(int node){
        visited[node] = true; //현재 노드 방문처리
        System.out.println("방문한 노드는" + node);

        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList[Node + 1];
        visited = new boolean[Node + 1];


        //간선 입력하기
        for (int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            

            //양방향 그래프이므로 양방향 연결
            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
        
    }

}
