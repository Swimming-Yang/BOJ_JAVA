//&BOJ_1074_Z;

package BOJ_1000;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;

    public static int cur_count;
    public static int cur_size;

    public static void main(String[] args) throws IOException{
        //^N -> 2^n승 배열 r -> r행 c -> c열
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());     
        
        double map_size = Math.pow(2, N);
        int imap_size = (int)map_size;
        map = new int[imap_size][imap_size];

        cur_count = 0;
        cur_size = imap_size;

        //*배열 값을 모두 0으로 채워줌 */
        for(int i = 0; i < imap_size; i++) {
            for(int j = 0; j < imap_size; j++) {
                map[i][j] = 0;
            }
        }
        //*타겟 좌표만 1로 갱신 */
        map[r][c] = 1;

        reculsive(imap_size, imap_size, r, c) {
            
        }
    }

}
