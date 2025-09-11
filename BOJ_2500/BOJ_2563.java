//*BOJ_2563_색종이 */
package BOJ_2500;
import java.io.*;
import java.util.*;

public class BOJ_2563 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] papersize;

    public static void main(String[] args) throws IOException{
        //*첫째 줄에 색종이의 수가 주어진다 */

        papersize = new int[100][100];
        int answer_count = 0;

        int paper = Integer.parseInt(br.readLine());
        for(int i = 0; i < paper; i++) {
            //*시작좌표를 받기 */
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int j = weight; j < weight + 10; j ++) {
                for(int k = height; k < height + 10; k++) {
                    papersize[j][k] = 1;
                }
            }
        }
        //*1의 개수를 세기 */
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(papersize[i][j] == 1) {
                    answer_count ++;
                }
            }
        }

        System.out.println(answer_count);

    }
}
