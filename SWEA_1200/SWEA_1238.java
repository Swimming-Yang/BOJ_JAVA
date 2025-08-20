//SWEA_1238_Contact
//cspell:ignore SWEA

package SWEA_1200;

import java.io.*;
import java.util.*;

public class SWEA_1238 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;

    public static int max_Depth;
    public static int max_Node;

    public static void main(String[] args) throws IOException{
        for(int testcase = 1; testcase <= 10; testcase++) {
        st = new StringTokenizer(br.readLine());
        int Data_lang = Integer.parseInt(st.nextToken());
        int start_node = Integer.parseInt(st.nextToken());

        //int Node = Data_lang / 2;

        //초기화
        graph = new ArrayList[101];
        visited = new boolean[101];
        max_Depth = 0;
        max_Node = 0;


        for(int i = 1; i < 101; i++) {
            graph[i] = new ArrayList<>();
        }

        //값 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Data_lang / 2; i++) {
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
        }

        bfs(start_node, 0);//시작노드와, depth

        System.out.println("#" + testcase + " " + max_Node);
        }

    }

    public static void bfs(int start_node, int depth) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start_node, depth});
        visited[start_node] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cur_node = current[0];
            int cur_depth = current[1];
        
            if(cur_depth > max_Depth) {
                max_Depth = cur_depth;
                max_Node = cur_node;
            } else if (cur_depth == max_Depth) {
                if(cur_node > max_Node) {
                    max_Node = cur_node;
                }
            }

            for(int next_node : graph[cur_node]) {
                if(!visited[next_node]) {
                    q.offer(new int[]{next_node, cur_depth + 1});
                    visited[next_node] = true;
                } 
            }
        }




    }


}
