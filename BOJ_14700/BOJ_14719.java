package BOJ_14700;

import java.io.*;
import java.util.*;

public class BOJ_14719 {
    public static int[] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[col];

        //*탐색중인 오른쪽 */
        int right = 0;
        int right_loc = 0;

        //*탐색중인 왼쪽 */
        int left = 0;
        int left_loc = 0;

        //*탐색이 와있는 현재 위치 */
        int current = 0;

        //*정답 */
        int answer = 0;
        
        //* */
        for(int i = current; i < col; i ++) {
            //*왼쪽벽 지정 */
            if(i != 0) {
                left = map[i];
                left_loc = i;
                //*탐색시 다음 좌표부터 탐색 */
                current = i + 1;
                break;
            }
        }

        
        



            }
