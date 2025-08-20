//BOJ_10845 큐
package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10845 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static Deque<Integer> q = new ArrayDeque<>();  // Deque 사용
    
    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());  // push일 때만 숫자 읽기
                q.offer(num);
            } else if (order.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.poll());
                }
            } else if (order.equals("size")) {
                System.out.println(q.size());
            } else if (order.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                }
            } else if (order.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekLast());  // 뒤쪽 원소 확인
                }
            }
        }
    }
}