package BOJ_1000;

import java.io.*;
import java.util.*;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_a = Integer.parseInt(st.nextToken());
        int num_b = Integer.parseInt(st.nextToken());

        int count = 0;

        LinkedList<Integer> Deque = new LinkedList<Integer>();

        for(int i = 0; i < num_a; i++) {
            Deque.offer(i);
        }

        int[] cur_arr = new int[num_b];

        for(int i = 0; i < num_b; i++) {
            int target_idx = cur_arr[i];

            int half_idx;


            if(Deque.size() % 2 == 0) {
                half_idx = Deque.size() / 2 - 1;
            } else { 
                half_idx = Deque.size() / 2;
            }

            if(target_idx <= half_idx) {
                for(int j = 0; j <target_idx; j++) {
                    int temp = Deque.pollFirst();
                    Deque.offerLast(temp);
                    count++;
                }
            } else {
                for (int j = 0; j < Deque.size(); j++) {
                    int temp = Deque.pollLast();
                    Deque.offerFirst(temp);
                    count++;
                }
            }
                    Deque.pollFirst();
        }
        System.out.println(count);    
    }
    
}
