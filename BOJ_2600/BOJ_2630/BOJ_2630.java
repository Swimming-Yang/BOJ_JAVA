//&BOJ_2563_색종이 만들기 */

package BOJ_2600.BOJ_2630;

import java.io.*;
import java.util.*;

public class BOJ_2630 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;

    static int white_count = 0;
    static int blue_count = 0;
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        //*그래프 초기화 */
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        divide(0, 0, n);
        System.out.println(white_count);
        System.out.println(blue_count);
    }
    
    //*색종이 조건 확인
    static boolean scan(int x, int y, int size) {
        int color = map[x][y];
        
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // 분할정복으로 색종이 개수 세기
    static void divide(int x, int y, int size) {
        // 현재 영역이 모두 같은 색이면
        if(scan(x, y, size)) {
            if(map[x][y] == 0) {
                white_count++;
            } else {
                blue_count++;
            }
            return;
        }
        
        //*같은 색이 아니면 디바이드
        int newSize = size / 2;
        
        // 좌상
        divide(x, y, newSize);
        // 우상
        divide(x, y + newSize, newSize);
        // 좌하
        divide(x + newSize, y, newSize);
        // 우하
        divide(x + newSize, y + newSize, newSize);
    }
}