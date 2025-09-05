//&BOJ_1927_최소힙
package BOJ_1900;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1927 {

    public static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase_num = Integer.parseInt(br.readLine());
        
        pq = new PriorityQueue<>();

        for(int i = 0; i < testcase_num; i++) {
            int cur_num = Integer.parseInt(br.readLine());
            if(cur_num == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.offer(cur_num);
            }
        }
    }

}
