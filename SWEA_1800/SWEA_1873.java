package SWEA_1800;

import java.io.*;
import java.util.*;

public class SWEA_1873 {

    public static char[][] map;
<<<<<<< HEAD
    public static String[][][] states; //row, col, dir

    public static int cr, cc, cd, nr, nc, sr, sc;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //*1. 첫번째 줄에 테스트 케이스의 수 T가 주어진다
        int testcase_num = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testcase_num; tc++) {
            st = new StringTokenizer(br.readLine());
=======
    public static char[][] answer;

    public static int[][][] states; //*row, col, dir */
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static char[] ts = {'^', '>', 'v', '<'};

    public static int cr, cc, td;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        //*첫째 줄에 테스트케이스의 수가 주어진다 */
        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
>>>>>>> 170762fd2922b7afe561dc26084e3ac32d77b596
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            map = new char[row][col];
<<<<<<< HEAD
            for(int i = 0; i < row; i++) {
                String line = br.readLine();
                for(int j = 0; j < col; j++) {
                    map[i][j] = line.charAt(j); // 수정: charAt(i) -> charAt(j)
                    char block = map[i][j];
                    //*현재 위치 파악*/
                    if(block == '^') {
                        cr = i;
                        cc = j;
                        cd = 0;
                    }
                    else if(block == '>') {
                        cr = i;
                        cc = j;
                        cd = 1;
                    }
                    else if(block == 'v') {
                        cr = i;
                        cc = j;
                        cd = 2;
                    }
                    else if(block == '<') {
                        cr = i;
                        cc = j;
                        cd = 3;
                    }
                }
            }
        
            int command = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for(int i = 0; i < command; i++) {
                char cur_com = commands.charAt(i);

                if(cur_com == 'U') { //*위로 이동 명령어가 나오면 */
                    nr = cr + dr[0];
                    nc = cc + dc[0];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            //*이전에 있었던 위치를 잔디로 바꾸고 */
                            map[cr][cc] = '.';
=======
            for(int j = 0; j < row; j++) {
                String line = br.readLine();
                for(int k = 0; k < col; k++) {
                    map[j][k] = line.charAt(k);
                    if(map[j][k] == '^') {
                        cr = j;
                        cc = k;
                        td = 0;
                    }
                    else if(map[j][k] == '>') {
                        cr = j;
                        cc = k;
                        td = 1;
                    }
                    else if(map[j][k] == 'v') {
                        cr = j;
                        cc = k;
                        td = 2;
                    }
                    else if(map[j][k] == '<') {
                        cr = j;
                        cc = k;
                        td = 3;
                    }
                }
            }

            int command = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for(int j = 0; j < command; j++) {
                char cur_cum = commands.charAt(j);
                if(cur_cum == 'U') {
                    //*탱크의 방향을 위로 바꾼 후 */
                    td = 0;
                    int nr = cr + dr[0];
                    int nc = cc + dc[0];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.';                           
>>>>>>> 170762fd2922b7afe561dc26084e3ac32d77b596
                            cr = nr;
                            cc = nc;
                        }
                    }
<<<<<<< HEAD
                    cd = 0;
                    map[cr][cc] = '^'; // 현재 위치에 탱크 표시
                }
                else if(cur_com == 'R') {
                    nr = cr + dr[1];
                    nc = cc + dc[1];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.';
                            cr = nr;
                            cc = nc;
                        }
                    }
                    cd = 1;
                    map[cr][cc] = '>'; // 현재 위치에 탱크 표시
                }
                else if(cur_com == 'D') {
                    nr = cr + dr[2];
                    nc = cc + dc[2];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.';
                            cr = nr;
                            cc = nc;
                        }
                    }
                    cd = 2;
                    map[cr][cc] = 'v'; // 현재 위치에 탱크 표시
                }
                else if(cur_com == 'L') {
                    nr = cr + dr[3];
                    nc = cc + dc[3];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.';
                            cr = nr;
                            cc = nc;
                        }
                    }
                    cd = 3;
                    map[cr][cc] = '<'; // 현재 위치에 탱크 표시
                }
                else if(cur_com == 'S') {
                    sr = cr;
                    sc = cc;

                    while(true) {
                        sr += dr[cd];
                        sc += dc[cd];

                        if(sr < 0 || sr >= row || sc < 0 || sc >= col) {
                            break;
                        }

                        if(map[sr][sc] == '*') {
                            map[sr][sc] = '.';
                            break;
                        }

                        else if(map[sr][sc] == '#') {
                            break;
=======
                    map[cr][cc] = ts[td];
                }
                else if(cur_cum == 'D') {
                    //*탱크의 방향을 아래로 바꾼 후 */
                    td = 2;
                    int nr = cr + dr[2];
                    int nc = cc + dc[2];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.';
                            cr = nr;
                            cc = nc;

                        }
                    }
                    map[cr][cc] = ts[td];
                }
                else if(cur_cum == 'L') {
                    //*탱크의 방향을 위로 바꾼 후 */
                    td = 3;
                    int nr = cr + dr[3];
                    int nc = cc + dc[3];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.'; 
                            cr = nr;
                            cc = nc;
                        }
                    }
                    map[cr][cc] = ts[td];
                }
                else if(cur_cum == 'R') {
                    //*탱크의 방향을 오른쪽으 바꾼 후 */
                    td = 1;
                    int nr = cr + dr[1];
                    int nc = cc + dc[1];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                        if(map[nr][nc] == '.') {
                            map[cr][cc] = '.';
                            cr = nr;
                            cc = nc;
                        }
                    }
                    map[cr][cc] = ts[td];
                }
                else if(cur_cum == 'S') {
                    int Bullet_r = cr + dr[td];
                    int Bullet_c = cc + dc[td];

                    while(Bullet_r >= 0 && Bullet_r < row && Bullet_c >= 0 && Bullet_c < col) {
                        if(map[Bullet_r][Bullet_c] == '*') {
                            map[Bullet_r][Bullet_c] = '.';
                            break;
                        }
                        else if(map[Bullet_r][Bullet_c] == '#') {
                            break;
                        }
                        else {
                            Bullet_r += dr[td];
                            Bullet_c += dc[td];
>>>>>>> 170762fd2922b7afe561dc26084e3ac32d77b596
                        }
                    }
                }
            }
<<<<<<< HEAD
            
            // 결과 출력
            System.out.print("#" + tc + " ");
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
=======
            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    sb.append(map[j][k]);
                }
                sb.append("\n");
            }
            System.out.print("#" + i+ " " + sb);
        }
    }
}
>>>>>>> 170762fd2922b7afe561dc26084e3ac32d77b596
