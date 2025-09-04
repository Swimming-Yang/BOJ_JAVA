import java.io.*;
import java.util.*;

public class BOJ_10709 {
    
    public static char[][] map;
    public static int[][] answer;
    public static int time;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //*첫번째 행에는 row, col이 공백으로 주어짐 */
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        answer = new int[row][col];

        for(int i = 0; i < row; i++) {
            Arrays.fill(answer[i], -1);
        }

        //*이어진 row만큼 w문자의 문자열이 주어짐(공백 x) */
        for(int i = 0; i < row; i++) {
            String word = br.readLine();
            for(int j = 0; j < col; j++) {
                map[i][j] = word.charAt(j);
            }
        }

        time = 0;

        while(time < col) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(map[i][j] == 'c' && answer[i][j] == -1) {
                        answer[i][j] = time;
                    }
                }
            }

        //배열을 밀어야 하는 로직
            for(int i = 0; i < row; i++) {
                for(int j = col - 1; j > 0; j--) {
                    map[i][j] = map[i][j - 1];
                }
                map[i][0] = '.';
            }
            time++;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
