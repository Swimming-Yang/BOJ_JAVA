package MST.Prim;

import java.util.Arrays;

public class adjMat {
    static final int N = 7;                              // 정점 수(0~6)

    public static void main(String[] args) {

        int [][] adj = new int[N][N];                    // 인접행렬(무방향 가중 그래프). 0이면 간선 없음

        // 간선 입력 (양방향)
        adj[0][1] = 2;  adj[1][0] = 2;
        adj[0][2] = 4;  adj[2][0] = 4;
        adj[0][5] = 8;  adj[5][0] = 8;
        adj[1][2] = 1;  adj[2][1] = 1;
        adj[1][3] = 19; adj[3][1] = 19;
        adj[2][5] = 5;  adj[5][2] = 5;
        adj[3][5] = 11; adj[5][3] = 11;
        adj[3][4] = 7;  adj[4][3] = 7;
        adj[3][6] = 15; adj[6][3] = 15;
        adj[4][6] = 3;  adj[6][4] = 3;
        adj[5][4] = 9;  adj[4][5] = 9;

        // ===== Prim Algorithm (Adjacency Matrix) =====

        int[] dist = new int[N];                         // MST 집합까지의 최소 간선 가중치
        Arrays.fill(dist, Integer.MAX_VALUE);            // 처음엔 무한대로 채움

        boolean[] visited = new boolean[N];              // MST 포함 여부
        int[] parent = new int[N];                       // 각 정점의 MST 내 부모(어느 정점에서 연결됐는지)
        Arrays.fill(parent, -1);                         // 시작 전 부모 없음

        dist[0] = 0;                                     // 임의의 시작 정점(0)을 선택: 가중치 0으로 시작
        int totalWeight = 0;                             // MST 전체 가중치 합

        for (int picked = 0; picked < N; picked++) {     // 정점 N개를 차례로 MST에 편입
            int minIdx = -1;                             // 이번에 선택될 최소 거리 정점 인덱스
            int minD = Integer.MAX_VALUE;                // 그 정점까지의 최소 거리

            // 방문하지 않은 정점 중 dist가 가장 작은 정점 선택
            for (int i = 0; i < N; i++) {
                if (!visited[i] && dist[i] < minD) {
                    minD = dist[i];
                    minIdx = i;
                }
            }

            // 방어코드: 연결 그래프가 아닐 경우(더 이상 선택할 정점이 없을 때) 종료
            if (minIdx == -1) break;

            visited[minIdx] = true;                      // 선택된 정점을 MST에 포함
            totalWeight += (minD == Integer.MAX_VALUE ? 0 : minD); // 시작정점은 0, 나머진 간선가중치 더함

            // 선택된 정점(minIdx)과 인접한 정점들에 대해 거리 갱신
            for (int v = 0; v < N; v++) {
                // 간선 존재하고, 아직 MST에 없고, 더 짧은 간선을 찾았다면 갱신
                if (adj[minIdx][v] != 0 && !visited[v] && adj[minIdx][v] < dist[v]) {
                    dist[v] = adj[minIdx][v];            // v까지의 최소 간선 가중치 갱신
                    parent[v] = minIdx;                  // v는 minIdx로부터 연결되는 것이 더 좋음
                }
            }
        }

        // 결과 출력: MST 간선들(부모-자식)과 총 가중치
        System.out.println("MST edges (u - v : w)");
        for (int v = 0; v < N; v++) {
            if (parent[v] != -1) {                       // 루트(시작 정점)는 부모가 없음
                System.out.println(parent[v] + " - " + v + " : " + adj[parent[v]][v]);
            }
        }
        System.out.println("Total weight = " + totalWeight);
    }
}
