// BOJ_1325_효율적인 해킹

package BOJ_1300;

import java.io.*;
import java.util.*;

public class BOJ_1325 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int com_num = Integer.parseInt(st.nextToken());      // 컴퓨터 수
        int testcase_num = Integer.parseInt(st.nextToken()); // 신뢰 관계 수

        List<List<Integer>> graph = new ArrayList<>();
        System.out.println(graph.size());

        // 그래프 초기화 0은사용 x 그래서 0은비워두고 1부터 com_num까지
        for (int i = 0; i <= com_num; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //B가 A를 신뢰한다 → A를 해킹하면 B도 해킹됨 → B → A
            graph.get(B).add(A);
        }

        int[] result = new int[com_num + 1]; // 각 컴퓨터에서 시작했을 때 해킹 가능한 컴퓨터 수
        int max = 0;

        // 모든 컴퓨터를 시작점으로 BFS 탐색
        for (int i = 1; i <= com_num; i++) {
            result[i] = bfs(i, graph, com_num);
            max = Math.max(max, result[i]);
        }

        // 해킹 가능한 컴퓨터 수가 최대인 시작점 출력
        for (int i = 1; i <= com_num; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    // BFS 
    public static int bfs(int start, List<List<Integer>> graph, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> list = graph.get(now);

            for (int i = 0; i < list.size(); i++) {
                int next = list.get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}
