package BOJ_1000;

import java.io.*;
import java.util.*;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_a = Integer.parseInt(st.nextToken());
        int num_b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int count = 0;

        LinkedList<Integer> deque = new LinkedList<Integer>();

        for(int i = 1; i <= num_a; i++) {
            deque.offer(i);
        }


        for(int i = 0; i < num_b; i++) {
            int target = Integer.parseInt(st.nextToken());


            int target_idx = deque.indexOf(target);

            int half_idx;
            if(deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else { 
                half_idx = deque.size() / 2;
            }

            if(target_idx <= half_idx) {
                for(int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } 

            else {
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            
            deque.pollFirst();
        }
        System.out.println(count);    
    }
}