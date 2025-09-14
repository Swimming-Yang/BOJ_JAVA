package BOJ_12800;

import java.io.*;
import java.util.*;

public class BOJ_12865_1 {
    public static int[][] items;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Item = Integer.parseInt(st.nextToken());
        int Value = Integer.parseInt(st.nextToken());

        //*넣거나 안넣거나 2가지 경우의수라 [][2] */
        items = new int[Item + 1][2];
        //*dp를 위한 모든 테이블 배열 */
        dp = new int[Item + 1][Value + 1];

        for(int i = 1; i <= Item; i++) {
        st = new StringTokenizer(br.readLine());
        items[i][0] = Integer.parseInt(st.nextToken()); // 무게
        items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for(int i = 1; i <= Item; i++) {
            for(int j = 1; j <= Value; j++) {
                if(items[i][0] > j) { //*해당 물품의 가치가 현재 배낭보다 크다면 (당연히 못넣음) */
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                }
            }
        }
        System.out.println(dp[Item][Value]);
    }
}
