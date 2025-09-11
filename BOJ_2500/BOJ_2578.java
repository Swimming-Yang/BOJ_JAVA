//*BOJ_2578_빙고 */

package BOJ_2500;

import java.io.*;
import java.util.*;

public class BOJ_2578 {

    public static int[][] map;
    public static int BingoCounter = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> q = new ArrayDeque<>();

        map = new int[5][5];
        int answer = 0;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //*사회자 */
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            }
        }

        //*숫자 체커 */
        while(!q.isEmpty()) {
            int num = q.poll();
            answer++;
        

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(map[i][j] == num) {
                        map[i][j] = 0;
                    }
                    BingoChecker();
                    if(BingoCounter >= 3) {
                        System.out.println(answer);
                    }
                }
            }
        }
    }
    //*빙고 체커 */
    public static void BingoChecker() {
    
        BingoCounter = 0;

    //*세로 체커 */
    for(int j = 0; j < 5; j++) {
        int count = 0;// 열별로
        for(int i = 0; i < 5; i++) { // 행을 확인
            if(map[i][j] == 0) {
                count++;
            }
        }
        if(count == 5) {
            BingoCounter++;
        }
    }
    
    //*가로 체커 */

    for(int i = 0; i < 5; i++) {
        int count = 0;
        for(int j = 0; j < 5; j++) {
            if(map[i][j] == 0) {
                count++;
            }
        }
        if(count == 5) {
            BingoCounter++;
        }
    }

    //*좌상 우하 체커 */
    int count = 0;
    for(int i = 0; i < 5; i++) {
        if(map[i][i] == 0) {
            count++;
        }
        if(count == 5) {
            BingoCounter++;
        }
    }


    //*우상 좌하 체커 */
    int count = 0;
    for(int i = 0; i < 5; i++) {
        if(map[i][4 - i] == 0) {
            count++;
        }
        if(count == 5) {
            BingoCounter++;
        }
    }

    }
}

