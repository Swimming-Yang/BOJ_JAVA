package BOJ_2600;

import java.io.*;
import java.util.*;

public class BOJ_2644 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int target; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫째줄에는 전체 사람의 수 n이 주어진다
        int person = Integer.parseInt(br.readLine());

        graph = new ArrayList[person + 1];
        for(int i = 0; i <= person; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[person + 1];

        // 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두사람의 번호가 주어진다
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken()); // Store target person in global variable

        // 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다
        int Edge = Integer.parseInt(br.readLine());

        // 넷째줄 부터는 부모 자식 간의 관계를 나타내는 두번호 x,y가 각 줄에 나온다
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            graph[fir].add(sec);
            graph[sec].add(fir);
        }

        int result = dfs(first, 0);
        System.out.println(result);
    }

    public static int dfs(int start, int depth) {
        visited[start] = true;

        if(start == target) {
            return depth;
        }
        for(int next : graph[start]) {
            if(!visited[next]) {
                int result = dfs(next, depth + 1);
                if(result != -1) {
                    return result;
                }
            }
        }
        
        visited[start] = false;
        return -1;
    }
}