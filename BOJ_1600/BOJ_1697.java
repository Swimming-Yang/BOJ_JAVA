package BOJ_1600;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치
        
        if(N >= K) {
            System.out.println(N - K);
            return;
        }
        
        System.out.println(bfs(N, K));
    }
    
    public static int bfs(int start, int target) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        
        q.offer(new int[]{start, 0});
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];   // 현재 위치
            int time = cur[1];  // 현재 시간
            
            // 목표 도달
            if(pos == target) {
                return time;
            }
            
            // 3가지 이동 방법
            int[] nextPos = {pos - 1, pos + 1, pos * 2}; // 핵심!
            
            for(int next : nextPos) {
                // 범위 체크 및 방문 체크
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, time + 1});
                }
            }
        }
        return -1; // 도달 불가능 (실제로는 발생하지 않음)
    }
}