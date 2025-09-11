//BOJ_2566 최댓값
package BOJ_2500;
import java.io.*;
import java.util.*;

public class BOJ_2566 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int arr[][] = new int[9][9];

        int max_num = Integer.MIN_VALUE;
        int max_x = 1; //최댓값의 x좌표
        int max_y = 1; //최댓값의 y좌표

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
  
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (arr[i][j] > max_num) {
                    max_num = arr[i][j];
                    max_x = i + 1;
                    max_y = j + 1;
                }
            }
        }  
            sb.append(max_num + "\n");
            sb.append(max_x).append(" ").append(max_y);

            System.out.println(sb);
            br.close();
    }

}
