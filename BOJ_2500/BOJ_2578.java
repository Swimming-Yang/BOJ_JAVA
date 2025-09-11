package BOJ_2500;

import java.io.*;
import java.util.*;

public class BOJ_2578 {

    public static int[][] map;
    public static int BingoCounter = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> q = new ArrayDeque<>();

        map = new int[5][5];
        int answer = 0;
        
        // 빙고판 입력
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부르는 번호들 입력
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            }
        }

        // 숫자를 하나씩 처리
        while(!q.isEmpty()) {
            int num = q.poll();
            answer++;
            
            // 해당 숫자를 찾아서 0으로 바꿈
            boolean found = false;
            for(int i = 0; i < 5 && !found; i++) {
                for(int j = 0; j < 5 && !found; j++) {
                    if(map[i][j] == num) {
                        map[i][j] = 0;
                        found = true;
                    }
                }
            }
            
            // 빙고 개수 체크
            BingoChecker();
            
            // 3개 이상의 빙고가 완성되면 종료
            if(BingoCounter >= 3) {
                System.out.println(answer);
                return;
            }
        }
    }
    
    // 빙고 체커
    public static void BingoChecker() {
        BingoCounter = 0;

        // 가로 체커
        for(int i = 0; i < 5; i++) {
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }
            if(count == 5) {
                BingoCounter++;
            }
        }
        
        // 세로 체커
        for(int j = 0; j < 5; j++) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }
            if(count == 5) {
                BingoCounter++;
            }
        }

        // 좌상-우하 대각선 체커
        int count1 = 0;
        for(int i = 0; i < 5; i++) {
            if(map[i][i] == 0) {
                count1++;
            }
        }
        if(count1 == 5) {
            BingoCounter++;
        }

        // 우상-좌하 대각선 체커
        int count2 = 0;
        for(int i = 0; i < 5; i++) {
            if(map[i][4 - i] == 0) {
                count2++;
            }
        }
        if(count2 == 5) {
            BingoCounter++;
        }
    }
}