import java.io.*;
import java.util.*;

public class practice {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        int Node = Integer.parseInt(br.readLine());
        int Edge = Integer.parseInt(br.readLine());

        //그래프 초기화
        graph = new ArrayList[Node + 1];
        visited = new boolean[Node + 1];

        for(int i = 0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }
        //간선 입력
        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next);
            } 
        }

    }

}
