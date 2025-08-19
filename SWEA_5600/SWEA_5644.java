//SWEA_5644_무선 충전

package SWEA_5600;

import java.io.*;
import java.util.*;

public class SWEA_5644 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static List<Integer>[][] available_BC;//좌표에서 이용할수 있는 충전소
    public static int[] BC_Power;

    public static int[] dx = {0, 0, 1, 0, -1};
    public static int[] dy = {0, -1, 0, 1, 0};

    public static int[] person_1;
    public static int[] person_2;

    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testcase_num; i++) {
            //이동시간, 충전소 개수
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); //이동 시간
            int BC_num = Integer.parseInt(st.nextToken());


            //그래프 초기화
            BC_Power = new int[BC_num];
            available_BC = new List[11][11];

            for(int x = 1; x <= 10; x++) {
                for(int y = 1; y <= 10; y++) {
                    available_BC[x][y] = new ArrayList<>();
                }
            }

            person_1 = new int[M];
            person_2 = new int[M];

            //사용자 A
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                person_1[j] = Integer.parseInt(st.nextToken());
            }

            //사용자 B
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                person_2[j] = Integer.parseInt(st.nextToken());
            }

            //충전소 정보
            for(int j = 0; j < BC_num; j++) {
                st = new StringTokenizer(br.readLine());
                int bc_x = Integer.parseInt(st.nextToken());
                int bc_y = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                BC_Power[j] = power;

                //이거 중요..//멘헤튼 거리 알고리즘
                for(int x = 1; x <= 10; x++) {
                    for(int y = 1; y <= 10; y++) {
                        if(range >= Math.abs(x - bc_x) + Math.abs(y - bc_y)) {
                            available_BC[x][y].add(j); 
                        }
                    }
                }
            }
            //Person_1시작위치
            int x_1 = 1;
            int y_1 = 1;

            //Person_2시작위치
            int x_2 = 10;
            int y_2 = 10;

            int total = 0;

            for(int move = 0; move <= M; move++) {
                List<Integer> person_1_charge = new ArrayList<>(available_BC[x_1][y_1]);
                List<Integer> person_2_charge = new ArrayList<>(available_BC[x_2][y_2]);

                person_1_charge.add(-1);
                person_2_charge.add(-1);
                
                int maxcharge = 0;
                for(int choice_1 : person_1_charge) {
                    for(int choice_2 : person_2_charge) {
                        int cur_charge = 0;
                        
                        int power1 = (choice_1 == -1) ? 0 : BC_Power[choice_1];
                        int power2 = (choice_2 == -1) ? 0 : BC_Power[choice_2];

                        if(choice_1 == choice_2 && choice_1 != -1) {
                            cur_charge = power1;  // 같은 충전소 공유
                        } else {
                            cur_charge = power1 + power2;  // 각자 사용
                        }
                        
                        maxcharge = Math.max(maxcharge, cur_charge);
                    }
                }

                total += maxcharge;
                if (move < M) {
                    int move_1 = person_1[move];
                    x_1 += dx[move_1];
                    y_1 += dy[move_1];

                    int move_2 = person_2[move];
                    x_2 += dx[move_2];
                    y_2 += dy[move_2];
                }
            }

            System.out.println("#" + i + " " +total);
        }

        
    }

}
