//BOJ_2190_점고르기2
package BOJ_2100;

import java.io.*;
import java.util.*;

public class BOJ_2190 {

   public static int[][] location;
   
   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static StringTokenizer st;
   public static void main(String[] args) throws IOException {
       
       st = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(st.nextToken());
       int A = Integer.parseInt(st.nextToken());
       int B = Integer.parseInt(st.nextToken());
       
       location = new int[N][2];
       
       for (int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           
           location[i][0] = x;
           location[i][1] = y;
       }
       
       int answer_count = 0;
       
       // 모든 x좌표와 y좌표 조합으로 사각형 시작점 만들기
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               int square_x = location[i][0];
               int square_y = location[j][1];
               
               int count = 0;
               for (int k = 0; k < N; k++) {
                   int px = location[k][0];
                   int py = location[k][1];
                   
                   if (px >= square_x && px <= square_x + A && py >= square_y && py <= square_y + B) {
                       count++;
                   }
               }
               
               answer_count = Math.max(answer_count, count);
           }
       }
       
       System.out.println(answer_count);
   }
}