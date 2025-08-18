//BOJ_1110_더하기 사이클

package BOJ_1100;

import java.io.*;
import java.util.*;

public class BOJ_1110 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int num = Integer.parseInt(br.readLine());
        int answer_count = 0;
        int current_num = num;

        while(true) {
            int new_num;
            if (current_num < 10) { //10보다 작은경우 
                int sum = current_num;
                new_num = current_num * 10 + sum % 10;
            } else { //10보다 큰 경우
                int sum = current_num / 10 + current_num % 10;
                new_num = (current_num % 10) * 10 + sum % 10;
            }
            answer_count++;

            if (new_num == num) {
                break;
            }
            current_num = new_num;
            
        }
        System.out.println(answer_count);
        
    }

}
