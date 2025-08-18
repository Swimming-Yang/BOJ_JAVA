package SWEA_1900;
//cspell:ignore SWEA
import java.io.*;
import java.util.*;

public class SWEA_1974 {

    static int[][] map;
    static StringBuilder sb;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int re = 0; re < testcase_num; re++) {
            map = new int[9][9];
            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer;
            if(check()) {
                answer = 1;
            } else {
                answer = 0;
            }
            
            sb.append("#").append(re + 1).append(" ").append(answer).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static boolean check() {
        for(int i = 0; i < 9; i++) {
            if(!Row(i)) {
                return false;
            }
        }
        
        for(int j = 0; j < 9; j++) {
            if(!Col(j)) {
                return false;
            }
        }
        
        for(int boxRow = 0; boxRow < 3; boxRow++) {
            for(int boxCol = 0; boxCol < 3; boxCol++) {
                if(!Box(boxRow, boxCol)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static boolean Row(int row) {
        boolean[] used = new boolean[10];

        for(int i = 0; i < 9; i++) {
            int num = map[row][i];
            if(num < 1 || num > 9 || used[num]) {
                return false;
            }
            used[num] = true;
        }
        return true;
    }
    
    public static boolean Col(int col) {
        boolean[] used = new boolean[10];

        for(int i = 0; i < 9; i++) {
            int num = map[i][col];
            if(num < 1 || num > 9 || used[num]) {
                return false;
            }
            used[num] = true;
        }
        return true;
    }
    
    public static boolean Box(int boxRow, int boxCol) {
        boolean[] used = new boolean[10];
        
        int startRow = boxRow * 3;
        int startCol = boxCol * 3;

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                int num = map[i][j];
                if(num < 1 || num > 9 || used[num]) {
                    return false;
                }
                used[num] = true;
            }
        }
        return true;
    }
}