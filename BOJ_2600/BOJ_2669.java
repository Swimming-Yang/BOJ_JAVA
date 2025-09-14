package BOJ_2600;

import java.io.*;
import java.util.*;

public class BOJ_2669 {

    public static int[][] map;
    public static void main(String[] args) throws IOException{
        map = new int[101][101];
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 4; i++) {
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

            for(int y = y1; y < y2; y++) {
                for(int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                if(map[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
