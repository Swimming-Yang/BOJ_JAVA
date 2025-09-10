package BOJ_11400;

import java.io.*;
import java.util.*;

public class BOJ_11403 {

    public static int[][] map;
    public static int INF = 100_000_000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        map = new int[size + 1][size + 1];

        for(int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= size; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) {
                    map[i][j] = 1;  // 직접 연결된 경우
                } else {
                    map[i][j] = INF;  // 연결되지 않은 경우
                }
            }
        }

        // 플로이드 워셜
        for(int k = 1; k <= size; k++) {
            for(int i = 1; i <= size; i++) {
                for(int j = 1; j <= size; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                if(map[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}