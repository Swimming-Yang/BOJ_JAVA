//BOJ_2580_스도쿠

package BOJ_2500;
import java.io.*;
import java.util.*;

public class BOJ_2580 {
    /*
     * 막힌부분
     * 1. 재귀
     * 2. 사각형 배열 체커
     * 3. system.exit(0)
     * 
     * 어려운부분
     * 재귀 + return
     * 
     */
    public static StringTokenizer st;
    public static StringBuilder sb;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] map = new int[9][9];
    
    public static void main(String[] args) throws IOException{
        //배열에 기본 값 채우기
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        num_selector(0, 0); //순회
    }
    
    public static void num_selector(int row, int col) {
        if (col == 9) { //한줄다했으니까
            num_selector(row + 1, 0); // 다음줄 0번인덱스로 이동
            return;
        }
        
        if(row == 9) {
            sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0); //모르는 부분 1 
        }
        
        if(map[row][col] == 0) { //값이 0이면
            for (int i = 1; i <= 9; i++) { //반복
                if (checker(row, col, i)) { // 체커로 숫자 검사
                    map[row][col] = i; // 숫자결정
                    num_selector(row, col + 1); //재귀
                    map[row][col] = 0; // 백트래킹으로 원복
                }
            }
        } else {
            num_selector(row, col + 1);
        }
    }
    
    // checker 함수
    public static boolean checker(int row, int col, int num) {
        // 행 검사
        for (int i = 0; i < 9; i++) { // 1~9반복해서
            if (map[row][i] == num) { //숫자가 이미 존재하면
                return false; //false
            }
        }
        // 열 검사
        for (int i = 0; i < 9; i++) { //1~9반복해서
            if (map[i][col] == num) {//숫자가 이미 있으면
                return false;//false
            }
        }
        

        // 네모검사 해결 못한부분 2
        int square_row = (row / 3) * 3;
        int square_col = (col / 3) * 3;
        for (int i = square_row; i < square_row + 3; i++) {
            for (int j = square_col; j < square_col + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}