//&2477_차량 정비소

package SWEA_2400;

import java.io.*;
import java.util.*;


public class SWEA_2477 {
    //^접수창구 소요 시간
    public static int[] Nt;
    //^정비창구 소요 시간
    public static int[] Mt;
    //^고객이 방문한 시간
    public static int[] Kt;
    
    //^현재 접수창구에 있는 손님 저장
    public static int[] N_customer;

    //^현재 정비창구에 있는 손님 저장
    public static int[] M_customer;

    //^고객의 방문정보가 담길 배열
    public static customer[] info;

    public static class customer{
        /*
         * ca = 해당 고객이 이용한 접수 창구번호
         * cb = 해당 고객이 이용한 정비 창구번호
         */
        int ca;
        int cb;

        public customer(int ca, int cb) {
            this.ca = ca;
            this.cb = cb;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase_num = Integer.parseInt(br.readLine());

        for(int test = 1; test <= testcase_num; test++) {
            /*
             * N = 접수 창구의 개수
             * M = 정비 창구의 개수
             * K = 차량 정비소를 방문한 고객의 수
             * A = 지갑을 두고간 고객이 이용한 접수 창구번호 A
             * B = 지갑을 두고간 고객이 이용한 접수 창구번호 B
             */
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Nt = new int[N + 1];
            N_customer = new int[N + 1];
            

            int M = Integer.parseInt(st.nextToken());
            Mt = new int[M + 1];
            M_customer = new int[M + 1];

            int K = Integer.parseInt(st.nextToken());
            Kt = new int[K + 1];
            info = new customer[K + 1];

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //^접수창구 걸리는시간 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                Nt[i] = Integer.parseInt(st.nextToken());
            }
            //^정비창구 걸리는시간 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++) {
                Mt[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                Kt[i] = Integer.parseInt(st.nextToken());
            }


            //*시뮬레이션 구현부 */
            //^접수 창구 끝나는 시간
            int[] N_end = new int[N + 1];

            //^정비 창구 끝나는 시간
            int[] M_end = new int[M + 1];

            Queue<Integer> N_wait = new LinkedList<>();
            Queue<Integer> M_wait = new LinkedList<>();

            //^현재 시간
            int cur_time = 0;

            //^다음 고객
            int next_customer = 1;

            //^끝난사람
            int finish = 0;

            while(finish < K) {
                //*시간에 도착해있는 고객 접수대기에 추가 */
                while(next_customer <= K && Kt[next_customer] <= cur_time) {
                    //*조건에 충족하면 접수대기에 추가 */
                    N_wait.offer(next_customer);
                    //*다음 손님 확인 */
                    next_customer++;
                }

                for(int i = 1; i <= N; i++) {
                    if(N_end[i] != 0 && N_end[i] <= cur_time) {
                        int customer_id = N_customer[i];
                        
                        // 접수창구 정보 미리 저장
                        info[customer_id] = new customer(i, 0);  // 접수창구 i, 정비창구는 아직 0
                        
                        M_wait.offer(customer_id);
                        N_end[i] = 0;
                        N_customer[i] = 0;
                    }
                }

                for(int i = 1; i <= M; i++) {
                    if(M_end[i] != 0 && M_end[i] <= cur_time) {
                        int customer_id = M_customer[i];
                        
                        //*정비창구 정보 추가
                        info[customer_id].cb = i;
                        
                        M_end[i] = 0;
                        M_customer[i] = 0;
                        finish++;
                            }
                        }

                for(int i = 1; i <= N; i++) {
                 // 빈 창구이고 대기 고객 있으면
                    if(N_end[i] == 0 && !N_wait.isEmpty()) {
                        int customer_id = N_wait.poll();
                        N_customer[i] = customer_id;
                        N_end[i] = cur_time + Nt[i];
                    }
                }

                for(int i = 1; i <= M; i++) {
                    if(M_end[i] == 0 && !M_wait.isEmpty()) {  // 빈 창구이고 대기 고객 있으면
                        int customer_id = M_wait.poll();
                        M_customer[i] = customer_id;
                        M_end[i] = cur_time + Mt[i];
                    }
                }
                        cur_time++;
                    }

                    int result = 0;
                    for(int i = 1; i <= K; i++) {
                        if(info[i] != null && info[i].ca == A && info[i].cb == B) {
                            result += i;
                        }
                    }

                    if(result == 0) {
                        System.out.println("#" + test + " -1");
                    } else {
                        System.out.println("#" + test + " " + result);
                    }
                }
    }
}


