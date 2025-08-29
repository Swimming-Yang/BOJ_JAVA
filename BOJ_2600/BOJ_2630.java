package BOJ_2600;

import java.io.*;
import java.util.*;

public class BOJ_2630 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    
    public static int map_size_weight;
    public static int map_size_height;

    public static int cur_m_size_weight;
    public static int cur_m_size_height;

    public static int start_weight;
    public static int start_height;

    public static int blue_paper = 0;
    public static int white_paper = 0;


    public static void main(String[] args) throws IOException{


        int papersize = Integer.parseInt(br.readLine());

        //*최초 높이 저장 */
        map_size_weight = papersize;
        map_size_height = papersize;

        //*분할한 현재 높이 저장 */
        cur_m_size_height = map_size_height;
        cur_m_size_weight = map_size_weight;

        map = new int[papersize][papersize];
        for(int i = 0; i < papersize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < papersize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        reculsive(0, 0);
        System.out.println(blue_paper + " " + white_paper);
    }

    public static void reculsive(int start_weight, int start_height) {

        int x = start_height;
        int y = start_weight;
        //*지금의 종이가 흰종이인지 파란색 종이인지 판단 */
        //*1이라면 파란종이 */
        if(map[start_height][start_weight] == 1) {
            for(int i = x; i < x + cur_m_size_height; i++) {
                for(int j = y; j < j + cur_m_size_weight; j++) {
                    //*만약 다르다면 */
                    if(map[i][j] != 1) {
                        cur_m_size_height /= 2;
                        cur_m_size_weight /= 2;
                        reculsive(start_weight, start_height);
                    }
                }
            }
            //*조건에 만족함 (색종이임) */
            blue_paper += 1;

            //*해당 좌표는 탐색이 끝낫으니 이동 */
            start_height += cur_m_size_height;
            start_weight += cur_m_size_weight;
        }
        //*0이라면 하얀종이 */
        else if(map[start_height][start_weight] == 0) {
            for(int i = x; i < x + cur_m_size_height; i++) {
                for(int j = y; j < j + cur_m_size_weight; j++) {
                    //*만약 다르다면 */
                    if(map[i][j] != 1) {
                        cur_m_size_height /= 2;
                        cur_m_size_weight /= 2;
                        reculsive(start_weight, start_height);
                    }
                }
            }
            //*조건에 만족함 (색종이임) */
            white_paper += 1;

            //*해당 좌표는 탐색이 끝낫으니 이동 */
            start_height += cur_m_size_height;
            start_weight += cur_m_size_weight;
        }
    }
}


