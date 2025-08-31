package BOJ_2600.BOJ_2630;

import java.io.*;
import java.util.*;

public class BOJ_2630_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    public static int newSize;

    public static int size;
    public static int white;
    public static int blue;

    public static void main(String[] args) throws IOException{
        size = Integer.parseInt(br.readLine());

        white = 0;
        blue = 0;
        
        map = new int[size][size];
        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, size);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int x, int y, int Size) {//*종이를 반으로 나누는 함수 */
        if(scan(x, y, Size)) { //*트루라면 */
            if(map[x][y] == 0) {
                white += 1;
            }
            else {
                blue += 1;
            }
            return;
        }
        else { //*아니라면 반으로 나눠야 함 */
            newSize = Size /= 2;
            divide(x, y, newSize);
            divide(x + newSize, y, newSize);
            divide(x, y + newSize, newSize);
            divide(x + newSize, y + newSize, newSize);
        }
    }

    public static boolean scan(int x, int y, int Size) { //*색종이인지 판단하는 함수 */
        //*시작 x, 시작 y, 종이의 크기 */
        int start = map[x][y];
        //*첫 시작이 하얀색인 경우 */
        for(int i = x; i < x + Size; i ++) {
            for(int j = y; j < y + Size; j++) {
                if(map[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }

}
