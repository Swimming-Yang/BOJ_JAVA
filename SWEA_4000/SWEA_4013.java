//& SWEA_4013_특이한 자석

package SWEA_4000;

import java.io.*;
import java.util.*;

public class SWEA_4013 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] arr; //*톱니바퀴의 극성의 정보 배열
    public static boolean[] willRotate;
    public static int[] direction;

    public static void main(String[] args) throws IOException{
        //* 입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고 */
        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= testcase_num; i++) {
            //*자석을 회전 시키는 횟수 K */
            int K = Integer.parseInt(br.readLine());
            //*각 자석의 정보 */

            //*자석의 정보를 저장 할 배열 초기화 */
            arr = new int[5][8]; //*1번부터 1번톱니

            for(int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 8; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            //*자석을 회전시키는 횟수 */
            for(int j = 0; j < K; j++) {
                willRotate = new boolean[5];
                direction = new int[5];

                st = new StringTokenizer(br.readLine());
                int cur_ring = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                //*현재 바퀴는 돌릴꺼에요 */
                willRotate[cur_ring] = true;
                //*현재 바퀴의 방향은 dir이에요 */
                direction[cur_ring] = dir;
                //*현재 인덱스 저장 */
                int current = cur_ring;

                //*왼쪽 전파*/
                while(current > 1) {
                    //*접촉점 비교 */
                    if(arr[current][6] != arr[current - 1][2]) {
                        willRotate[current - 1] = true;
                        direction[current - 1] = -direction[current];
                        current--;
                    } else { //*자성이 같다면 */
                        break;
                    }
                }

                //*다시 시작점으로 초기화*/
                current = cur_ring;

                //*오른쪽 전파*/
                while(current < 4) {
                    //*접촉점 비교 */
                    if(arr[current][2] != arr[current + 1][6]) {
                        willRotate[current + 1] = true;
                        direction[current + 1] = -direction[current];
                        current++;
                    } else {
                        break;
                    }
                }

                //*회전 실행
                for(int k = 1; k <= 4; k++) {
                    if(willRotate[k]) {
                        rotate(k, direction[k]);
                    }
                }
            }
            
            //*점수 계산
            int score = 0;
            if(arr[1][0] == 1) score += 1;  // 1번 자석
            if(arr[2][0] == 1) score += 2;  // 2번 자석
            if(arr[3][0] == 1) score += 4;  // 3번 자석
            if(arr[4][0] == 1) score += 8;  // 4번 자석
            
            System.out.println("#" + i + " " + score);
        }
    }

    public static void rotate(int magnetNum, int dir) {
        // 배열을 덱으로 변환
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < 8; i++) {
            deque.add(arr[magnetNum][i]);
        }

        if(dir == 1) {  //* */ 시계방향
            int last = deque.pollLast();   // 맨 뒤에서 빼기
            deque.addFirst(last);          // 맨 앞에 넣기
        } else {        //* */ 반시계방향 (dir == -1)
            int first = deque.pollFirst(); // 맨 앞에서 빼기
            deque.addLast(first);          // 맨 뒤에 넣기
        }

        //* 덱을 다시 배열로 변환
        int idx = 0;
        for(int value : deque) {
            arr[magnetNum][idx++] = value;
        }
    }
}