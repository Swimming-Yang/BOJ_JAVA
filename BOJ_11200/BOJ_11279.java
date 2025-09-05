//&BOJ_11279 최대 힙

package BOJ_11200;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());

        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase_num; i++) {
            int cur_num = Integer.parseInt(br.readLine());
            if(cur_num != 0) {
                pq.offer(cur_num);
            }

            else {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } 
                else {
                    System.out.println(pq.poll());
                }
            }
        }
    }

}
