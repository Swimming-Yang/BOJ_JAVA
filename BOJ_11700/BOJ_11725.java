//BOJ_11725 트리의 부모 찾기

package BOJ_11700;

import java.io.*;
import java.util.*;

public class BOJ_11725 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static List<List<Integer>> map_List;
    public static boolean[] visited;
    public static int[] parent;

    public static int standard;//기준숫자 정점 = N 노드 = N -1;
    public static void main(String[] args) throws IOException{
        standard = Integer.parseInt(br.readLine());
        //각 배열, 리스트 초기화
        map_List = new ArrayList<>();
        for(int i = 0; i <= standard; i++) {
            map_List.add(new ArrayList<>());
        }
        visited = new boolean[standard + 1];
        parent = new int[standard + 1];

        //엣지 케이스 입력
        for(int i = 0; i < standard - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //양방향
            map_List.get(start).add(end);
            map_List.get(end).add(start);
        }

        bfs();
        for(int i = 2; i <= standard; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        //큐에 하나 삽입
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int next : map_List.get(current)) {

                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    q.offer(next);
                } 
            }
        }
    }

}
