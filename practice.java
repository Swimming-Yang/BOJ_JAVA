import java.io.*;
import java.util.*;

public class practice {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    public static int white;
    public static int blue;

    public static void main(String[] args) throws IOException{


        //*첫째 줄에는 종이 한변의 길이 N이 주어짐 
        int size = Integer.parseInt(br.readLine());

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

    public static void divide(int x, int y, int size) {
        if(scan(x, y, size)) {
            if(map[x][y] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        //else
        int newSize = size / 2;
        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);
    }

    public static boolean scan(int x, int y, int size) {
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
}