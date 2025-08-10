//BOJ_1325_효율적인 해킹 static변수 선언

package BOJ_1300.BOJ_1325;

import java.io.*;
import java.util.*;

public class BOJ_1325_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int node;
    static int edge;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        //그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        boolean [] visited = new boolean[node + 1];

        //간선 채우기
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            graph.get(end).add(start); //단방향 그래프
        }

        //해킹 가능한 함수를 저장할 배열
        int[] result = new int[node + 1];
        int max = 0;

        for (int i = 1; i <= node; i++) {//모든 노드를 스타트 노드로 하는 bfs탐색
            result[i] = bfs(i, graph, node);
        
            if (result[i] > max) {
                max = result[i];
            }
        }

        for (int i =1; i <= node; i++) {
            if (result[i] == max) {
                sb.append(i + " ");
            }

        }

        System.out.println(sb.toString());

        
    }
    public static int bfs(int start, List<List<Integer>> graph, int node) {
        boolean []visited = new boolean[node + 1]; //방문배열 초기화

        Queue <Integer> q = new LinkedList<>();
        visited[start] = true;

        q.offer(start);

        int count = 1; // => 방문노드 컴퓨터 해킹이니 1부터 시작

        while (!q.isEmpty()) {
            int current_node = q.poll();

            for(int next_node : graph.get(current_node)) {
                if (!visited[next_node]) {
                    visited[next_node] = true;
                    q.offer(next_node);
                    count++;
                }
            }
        }
        return count;
    }

}
