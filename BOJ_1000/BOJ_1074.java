//&BOJ_1074_Z;

package BOJ_1000;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;

    public static int count = 1;


    public static void main(String[] args) throws IOException{
        //^N -> 2^n승 배열 r -> r행 c -> c열
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());     
        
        double map_size = Math.pow(2, N);
        int size = (int)map_size;
        map = new int[size][size];

        0 * Math.pow(2, size);
    }
}   



