package BOJ_11700;

import java.io.*;
import java.util.*;

public class BOJ_11780 {
    static final int INF = 100_000_000;
    static int[][] map;
    static int[][] next; // 경로 복원용
    static int Node; // 노드 수
    static int Edge; // 간선 수
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Node = Integer.parseInt(br.readLine());
        Edge = Integer.parseInt(br.readLine());
        
        map = new int[Node + 1][Node + 1];
        next = new int[Node + 1][Node + 1];
        
        // 초기화
        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = INF;
                }
                next[i][j] = -1; // 경로가 없음을 의미
            }
        }
        
        // 간선 입력
        for(int i = 0; i < Edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            // 중복 간선 처리 (더 작은 비용으로)
            if(map[start][end] > weight) {
                map[start][end] = weight;
                next[start][end] = end; // start에서 end로 직접 가는 경우
            }
        }
        
        // 플로이드-워셜
        for(int mid = 1; mid <= Node; mid++) {
            for(int str = 1; str <= Node; str++) {
                for(int ed = 1; ed <= Node; ed++) {
                    if(map[str][mid] != INF && map[mid][ed] != INF) {
                        if(map[str][ed] > map[str][mid] + map[mid][ed]) {
                            map[str][ed] = map[str][mid] + map[mid][ed];
                            next[str][ed] = next[str][mid]; // 경로 업데이트
                        }
                    }
                }
            }
        }
        
        // 최단거리 출력
        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(map[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
        
        // 경로 출력
        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(i == j || map[i][j] == INF) {
                    System.out.println("0");
                } else {
                    ArrayList<Integer> path = getPath(i, j);
                    System.out.print(path.size() + " ");
                    for(int vertex : path) {
                        System.out.print(vertex + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    
    // 경로 복원 함수
    static ArrayList<Integer> getPath(int start, int end) {
        ArrayList<Integer> path = new ArrayList<>();
        
        if(next[start][end] == -1) {
            return path; // 경로가 없음
        }
        
        int current = start;
        path.add(current);
        
        while(current != end) {
            current = next[current][end];
            path.add(current);
        }
        
        return path;
    }
}