//SWEA_1267_작업순서 
//cspell:ignore SWEA
/* 
 * 선행관계 -> 일방향 그래프 
 * 테스트 케이스 -> 10 
 * 위상정렬 -> 카한 알고리즘
 */
package SWEA_1200;

import java.io.*;
import java.util.*;

public class SWEA_1267 {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;
    
    public static int[][] graph;
    public static boolean[] visited;
    public static int[] depth;
    
    public static int Node;
    public static int Edge;
    
    public static void main(String[] args) throws IOException{
        int testcase_num = 10;
        
        for(int i = 1; i <= testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            Node = Integer.parseInt(st.nextToken());
            Edge = Integer.parseInt(st.nextToken());
            
            //초기화
            graph = new int[Node + 1][Node + 1];
            visited = new boolean[Node + 1];
            depth = new int[Node + 1];
            
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < Edge; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
                depth[y]++;
            }
            
            System.out.print("#" + i + " ");
            
            // 카한 알고리즘
            Queue<Integer> q = new LinkedList<>();
            
            // 진입차수가 0인 모든 노드를 큐에 삽입
            for(int j = 1; j <= Node; j++) {
                if(depth[j] == 0) {
                    q.offer(j);
                }
            }
            
            // 큐가 빌 때까지 반복
            while(!q.isEmpty()) {
                int current = q.poll();
                System.out.print(current + " ");
                
                // current와 연결된 노드들의 깊이 --
                for(int k = 1; k <= Node; k++) {
                    if(graph[current][k] == 1) {
                        depth[k]--;
                        if(depth[k] == 0) {
                            q.offer(k);
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}