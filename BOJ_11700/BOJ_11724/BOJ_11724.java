//BOJ_11724_연결 요소의 개수

package BOJ_11700.BOJ_11724;

import java.io.*;
import java.util.*;

public class BOJ_11724 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean[] visited;
    public static int[][] map;

    public static int Node;
    public static int Edge;


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        Node = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());

        visited = new boolean[Node + 1];
        map = new int[Node + 1][Node + 1];

        //간선 정보 입력
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }

        int answer_count = 0;

        for(int i = 1; i <= Node; i++) {
            if(!visited[i]) {
                dfs(i);
                answer_count++;
            }
        }

        System.out.println(answer_count);
    }

    public static void dfs(int start){
        visited[start] = true;

        for(int i = 1; i <= Node; i++) {
            if(map[start][i] == 1 & !visited[i]) {
                dfs(i);
            }
        }
    }

}
