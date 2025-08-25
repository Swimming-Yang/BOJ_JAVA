//DFS_인접리스트 기반 (그래프/트리)
/*
전역 변수 선언
graph: 인접리스트 배열 (각 노드마다 연결된 노드들의 리스트)
visited: 방문 체크 배열 (boolean)
입력 처리용 변수들

DFS 함수 (재귀)
함수 dfs(현재노드):
    1. 현재노드를 방문처리 (visited[현재노드] = true)
    2. 현재노드 출력 또는 처리
    
    3. 현재노드의 인접리스트를 순회:
        각 인접노드에 대해:
            만약 인접노드가 방문되지 않았다면:
                dfs(인접노드) 재귀호출
메인 함수
1. 입력 받기:
   - 노드 개수 (Node)
   - 간선 개수 (Edge)

2. 자료구조 초기화:
   - graph 배열을 크기 (Node+1)로 초기화
   - visited 배열을 크기 (Node+1)로 초기화
   - 각 graph[i]를 빈 리스트로 초기화

3. 간선 정보 입력:
   Edge번 반복:
       - 시작노드, 끝노드 입력받기
       - 양방향 그래프이므로:
         * graph[시작노드].add(끝노드)
         * graph[끝노드].add(시작노드)

4. DFS 탐색 시작:
   - dfs(1) 호출 (1번 노드부터 시작)
 */

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
