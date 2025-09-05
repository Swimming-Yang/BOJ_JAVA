package BOJ_14700.BOJ_14719;

import java.io.*;
import java.util.*;

public class BOJ_14719 {

    public static int[][] map;

    /*
     * 벽 = 1
     * 공기 = 0
     * 물 = 2
     */
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        int answer_count = 0;

        for(int i = 0; i < row; i++) {
            Arrays.fill(map[i], 0);
        }

        //*벽세우기 */
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < col; i++) {
            int cur_col = Integer.parseInt(st.nextToken());
            for(int j = row - cur_col; j < row; j++) {
                map[j][i] = 1;
            }
        }

        //*한칸씩 물을 넣으면서 비교 */
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {

                //*1.해당 칸이 벽일때 */
                if(map[i][j] == 1) {
                    continue;
                }

                //*2. 해당 칸이 공기일때 */
                else if(map[i][j] == 0) {
                    boolean leftCondition = false;
                    boolean rightCondition = false;

                    //*2.1 해당 칸 기준 왼쪽에 벽이 있는지 확인 */
                    for(int left = 0; left < j; left++) {
                        if(map[i][left] == 1) {
                            leftCondition = true;
                            break;
                        }
                    }
                    //*2.2 해당 칸 기준 오른쪽 */
                    for(int right = j + 1; right < col; right++) {
                        if(map[i][right] == 1) {
                            rightCondition = true;
                            break;
                        }
                    }

                    if(leftCondition && rightCondition) {
                        map[i][j] = 2;
                        answer_count += 1;
                    }
                }
            }
        }
        System.out.println(answer_count);
    }
}

