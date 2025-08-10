//BOJ_5568_BFS풀이

package BOJ_5500.BOJ_5567;

import java.io.*;
import java.util.*;

public class BOJ_5567_2 {

    static boolean[] visited;
    static int [][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int node;


    public static void main(String[] args) throws IOException{

        node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        
        map = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        //그래프 만들기
        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = map[end][start] = 1; //양방향 처리
        }

        int person_count = bfs();
        System.out.println(person_count);
        
    }

    public static int bfs() {
        //큐 생성
        Queue <Integer> q = new LinkedList<Integer>();

        q.offer(1);
        visited[1] = true;

        int count = 0;
        int depth = 0;

        while(!q.isEmpty() && depth < 2) {
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++) {
                int current = q.poll();

                for (int next = 1; next <= node; next++) {
                    if(map[current][next] == 1 && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                        count++;
                    }
                }
            }
            depth++;
        }
        return count;

        }

    }

