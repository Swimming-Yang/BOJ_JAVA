//BOJ_5567_1 결혼식 연습

package BOJ_5500;

import java.io.*;
import java.util.*;

public class BOJ_5567_1 {
    //visited 배열을 굳이 2차원으로 해야하는가?
    //사람의 방문 여부만 체크해야하니 1차원으로 충분함.
    static boolean []visited;
    static int [][] map;

    static int dfs_count;
    static int friend_count;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int friend;

    //사방탐색이 필요한가?
    //노드 탐색이니 필요없음

    public static void main(String[] args) throws IOException{
        friend = Integer.parseInt(br.readLine());
        visited = new boolean[friend + 1];
        map = new int[friend + 1][friend + 1];

        int testcase_num = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = map[end][start] = 1;
        }

        friend_count = 0;
        //이 상황에서 dfs로 어떻게 들어가지? 시작은 무조건 1이긴한거같은데 (1, 1)부터 시작하면 되나?

        dfs(1, 0);//상근이 부터 시작
        System.out.println(friend_count);
    }

    public static void dfs(int person, int depth) {
        visited[person] = true;

        if (depth >= 2) return;

        for(int next = 1; next <= friend; next++) {
            if(map[person][next] == 1 && !visited[next]) {
                friend_count += 1;
                dfs(next, depth + 1);
            }

        }


    }

}
