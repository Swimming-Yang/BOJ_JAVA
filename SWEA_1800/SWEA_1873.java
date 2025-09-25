package SWEA_1800;

import java.io.*;
import java.util.*;

public class SWEA_1873 {

    public static char[][] map;
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
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            map = new char[row][col];
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
                            cr = nr;
                            cc = nc;
                        }
                    }
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
                        }
                    }
                }
            }
            
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