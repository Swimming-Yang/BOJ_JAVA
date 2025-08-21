//BOJ_1966_프린터 큐

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1966 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            //N -> 문서의 개수 M -> 타깃문서가 몇번째인지 
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int answer_count = 0;

            while(!q.isEmpty()) {
                int[] current = q.poll();
                boolean Max = true;

                // ArrayDeque에서 인덱스 접근을 위한 Iterator 사용
                /*
                 * 구현 못한 부분
                 * 
                 */
                for(int[] doc : q) {
                    if(current[1] < doc[1]) { //중요순위가 낮다면
                        Max = false; //Max를 false로 변경
                        break; //탈출
                    }
                }

                if(Max) {
                    answer_count++;
                    if(current[0] == M) {
                        System.out.println(answer_count);
                        break;
                    }
                } else {
                    q.offerLast(current); //탈출 되면 다시 뒤로 넣고
                }
            }
        }
    }
}