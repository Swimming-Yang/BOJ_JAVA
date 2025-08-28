//cspell:ignore reculsive

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1913 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static int[][] arr;
    //*하 우 상 좌 */
    //* 아래로 가려면 y좌표만 1개 올라가야함
    public static int dx[] = {1, 0, -1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static int num;
    public static int target_num;
    public static int answer_x, answer_y;

    //*1. 시작점을 [1][1]로 잡고 사방탐색을 진행함 */
    //*하 -> 우 -> 상 -> 좌 */
    //*이때 범위탐색을 진행해서 범위에 겹치면 dx dy값을 + 1시킴 */
    //*더이상 사방탐색 할 곳이 없거나 숫자가 1인경우에 반복을 종료 */

    public static void main(String[] args) throws IOException{
        num = Integer.parseInt(br.readLine());
        target_num = Integer.parseInt(br.readLine());

        arr = new int[num][num];
        //* 시작점을 [0][0]로 지정하고 시작 넘버는 num * num
        int start_num = num * num;
        //*시작 위치의 좌표 */
        int cx = 0;
        int cy = 0;
        int dir = 0;

        reculsive(start_num, cx, cy, dir);

        sb = new StringBuilder();
        for(int row = 0; row < num; row ++) {
            for(int col = 0; col < num; col++) {
                sb.append(arr[row][col]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(answer_x + " " + answer_y);
        }
        
        public static void reculsive(int start_num, int cx, int cy, int dir) {
            //*종료조건을 먼저 적어 봅시다 */
            if(start_num == 0) {
                return;
            }
        
            //*재귀의 시작위치를 찍어봅시다 */
            arr[cx][cy] = start_num;
            if(start_num == target_num) {
                answer_x = cx + 1;
                answer_y = cy + 1;
            }

            //*다음 좌표는 현재위치 + 조건에 따른 이동 */
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            //*벽또는 이미 입력된 값이라면 방향을 틀어주는 조건 */
            if(nx < 0 || ny < 0 || nx > num - 1 || ny > num -1 || arr[nx][ny] != 0) {
                //*방향을 틀어줌 */
                dir = ((dir + 1) % 4);
                nx = cx + dx[dir];
                ny = cy + dy[dir];
            }
            start_num--;
            //*이제 다음꺼 찍으러 감 */
            reculsive(start_num, nx, ny, dir);


        }

    }


