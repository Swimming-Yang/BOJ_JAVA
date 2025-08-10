//BOJ_5567_3 인접리스트로 BFS

package BOJ_5500.BOJ_5567;

import java.io.*;
import java.util.*;

public class BOJ_5567_3 {

    static List<List<Integer>> graph;
    static boolean [] visited;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        //리스트 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            graph.add(new LinkedList<>());
        }

        visited = new boolean[node + 1];

        //간선 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        //bfs 호출
        int result = bfs();
        System.out.println(result);
        
    }

    public static int bfs() {
        Queue <int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0}); //배열에 방문노드 + 깊이값이 들어간 int 배열을 넣음
        visited[1] = true; //상근이 노드 방문

        int count = 0;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int current_node = current[0]; //현재 방문하고 있는 노드
            int current_depth = current[1]; //현재 노드의 깊이

            if (current_depth > 1) {
                continue;
            }

            for(int friend : graph.get(current_node)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    count++;
                    q.offer(new int[]{friend, current_depth + 1});
                }
            }
                }
                return count;
    }
    


}


