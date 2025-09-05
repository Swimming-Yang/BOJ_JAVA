//&BOJ_14499_주사위굴리기

package BOJ_14400;

import java.io.*;
import java.util.*;

public class BOJ_14499 {

    public static int[][] map;
    public static int[] dice;
    public static int[] temp;
    public static int[] command;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*
         * 지도세로 크기 row;
         * 지도가로 크기 col;
         * 주사위를 놓은곳의 x좌표 : dice_x
         * 주시위를 놓은곳의 y좌표 : y
         * 명령의 개수 : k 
         */

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dice_x = Integer.parseInt(st.nextToken());
        int dice_y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        dice = new int[6];
        temp = new int[6];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //*명령 배열에 입력 */

        command = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int comm = Integer.parseInt(st.nextToken());
            command[i] = comm;
        }


        //*명령 진행*/
        for(int i = 0; i < command.length; i++) {
            int cur_command = command[i];

            if(cur_command == 1) { //동
                dice_y += 1;
                if(!loc_checker(dice_x, dice_y, row, col)) {
                    dice_y -= 1;
                continue;
                } else {
                    rollEast();
                    renewal(dice_x, dice_y);
                    System.out.println(dice[0]);

                }       
            }
            else if(cur_command == 2) { //서
                dice_y -= 1;
                if(!loc_checker(dice_x, dice_y, row, col)) {
                    dice_y += 1;
                continue;
                } else {
                    rollWest();
                    renewal(dice_x, dice_y);
                    System.out.println(dice[0]);
                }

            }
            else if(cur_command == 3) { //북
                dice_x -= 1;
                if(!loc_checker(dice_x, dice_y, row, col)) {
                    dice_x += 1;
                continue;
                } else {
                    rollNorth();
                    renewal(dice_x, dice_y);
                    System.out.println(dice[0]);
                }


            }
            else if(cur_command == 4) { //남
                dice_x += 1;
                if(!loc_checker(dice_x, dice_y, row, col)) {
                    dice_x -= 1;
                continue;
                } else {
                    rollSouth();
                    renewal(dice_x, dice_y);
                    System.out.println(dice[0]);

                }


            }
        }
    }

    public static boolean loc_checker(int x, int y, int row, int col){
        boolean checker = true;
        if(x < 0 || x >= row || y < 0 || y >= col) {
            checker = false;
        }
        return checker;
    }

    public static void renewal(int loc_x, int loc_y) {
        if(map[loc_x][loc_y] == 0) {
            // 지도 칸이 0이면: 주사위 바닥면을 지도로 복사
            map[loc_x][loc_y] = dice[5];  // dice[5]는 바닥면
        } else {
            // 지도 칸이 0이 아니면: 지도 값을 주사위로 복사, 지도는 0
            dice[5] = map[loc_x][loc_y];
            map[loc_x][loc_y] = 0;
        }
    }


    public static void rollEast() { // 동쪽(1번 명령)
    int temp = dice[0];    // 위
    dice[0] = dice[3];     // 왼쪽 → 위
    dice[3] = dice[5];     // 아래 → 왼쪽
    dice[5] = dice[2];     // 오른쪽 → 아래
    dice[2] = temp;        // 위 → 오른쪽
    }

    public static void rollWest() { // 서쪽(2번 명령)
        int temp = dice[0];    // 위
        dice[0] = dice[2];     // 오른쪽 → 위
        dice[2] = dice[5];     // 아래 → 오른쪽
        dice[5] = dice[3];     // 왼쪽 → 아래
        dice[3] = temp;        // 위 → 왼쪽
    }

    public static void rollNorth() { // 북쪽(3번 명령)
        int temp = dice[0];    // 위
        dice[0] = dice[1];     // 앞 → 위
        dice[1] = dice[5];     // 아래 → 앞
        dice[5] = dice[4];     // 뒤 → 아래
        dice[4] = temp;        // 위 → 뒤
    }

    public static void rollSouth() { // 남쪽(4번 명령)
        int temp = dice[0];    // 위
        dice[0] = dice[4];     // 뒤 → 위
        dice[4] = dice[5];     // 아래 → 뒤
        dice[5] = dice[1];     // 앞 → 아래
        dice[1] = temp;        // 위 → 앞
    }
}


