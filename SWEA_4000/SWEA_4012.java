//SWEA_4012_요리사
//cspell:ignore SWEA
//뭔생각으로 풀었는지 모르겠는 코드 

package SWEA_4000;

import java.io.*;
import java.util.*;

public class SWEA_4012 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    //public static int[][] visited;
    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());



        for (int i = 1; i <= testcase_num; i++) {

            int map_size = Integer.parseInt(br.readLine());

            //초기화 구역
            map = new int[map_size][map_size];
            int answer = Integer.MAX_VALUE; //정답

            for(int j = 0; j < map_size; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < map_size; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0; j < map_size; j++) {
                for(int k = 0; k < map_size; k++) {
                    if(j == k) {
                        continue;
                    } else {
                        int cur_score = Math.abs(map[j][k] - map[k][j]);

                        if (cur_score < answer) {
                            answer = cur_score;
                        }
                    }
                }
            }
            System.out.println("#" + testcase_num + " " + answer);
        }
    }
}
