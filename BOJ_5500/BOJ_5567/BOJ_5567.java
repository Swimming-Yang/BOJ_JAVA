//BOJ_5567_결혼식

package BOJ_5500.BOJ_5567;

import java.io. *;
import java.util. *;

public class BOJ_5567 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        int n = Integer.parseInt(br.readLine()); // 총 사람 수
        int m = Integer.parseInt(br.readLine()); // 친구 관계 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph
                .get(a)
                .add(b);
            graph
                .get(b)
                .add(a);
        }

        // BFS 시작
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // 본인 번호 = 1, 거리 = 0
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int depth = current[1];

            if (depth >= 2) 
                continue;
            
            for (int friend : graph.get(person)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(new int[]{
                        friend, depth + 1
                    });
                    count++; // 초대 인원 추가
                }
            }
        }

        System
            .out
            .println(count);
    }
}
