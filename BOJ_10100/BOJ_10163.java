//&색종이

package BOJ_10100;

import java.io.*;
import java.util.*;

public class BOJ_10163 {
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[1002][1002];
        

        int paper = Integer.parseInt(br.readLine());
        for(int i = 1; i <= paper; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int row = y; row < y + height; row++) {      // y부터 y+height-1까지
                for(int col = x; col < x + width; col++) {   // x부터 x+width-1까지
                    map[row][col] = i;  // 색종이 번호로 표시
                }
            }
        }
        for(int i = 1; i <= paper; i++) {
            int count = 0;
            for(int j = 0; j <= 1001; j++) {
                for(int k = 0; k <= 1001; k++) {
                    if(map[j][k] == i) count++; 
                }
            }
            System.out.println(count);
        }
    }

}
