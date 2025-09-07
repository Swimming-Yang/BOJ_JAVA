//&구간합 구하기 5

package BOJ_11600;

import java.io.*;
import java.util.*;

import z_java_test_01.p1_02.location;

public class BOJ_11660 {

    public static int[][] map;
    public static int[][] new_map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int testcase_num = Integer.parseInt(st.nextToken());

        map = new int[size + 1][size + 1];
        for(int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= size; i++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }    
        }

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            new_map = new int[end_x - start_x][end_y - start_y];
            

        }
    }

}
