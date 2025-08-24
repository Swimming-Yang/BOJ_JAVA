package BOJ_28200;

import java.io.*;
import java.util.*;

public class BOJ_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase_num = Integer.parseInt(br.readLine());

        LinkedList<Integer> deque = new LinkedList<Integer>();

        for(int i = 0; i < testcase_num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            
            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                deque.offerFirst(b);
            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                deque.offerLast(b);
            } else if (a == 3) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (a == 4) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println(-1);
                }
            } else if (a == 5) {
                System.out.println(deque.size());
            } else if (a == 6) {
                if(deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (a == 7) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (a == 8) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}