//BOJ_2231_분해합

package BOJ_2200;

import java.io.*;
import java.util.*;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //목표한 숫자
        int str_num;

        if(N < 63) {
            str_num = 1;
        } else {
            str_num = N - 63;
        }

        while(true) {
            /*
             * 숫자를 받음 -> str로 변경
             * 각자리를 분리 스트링 빌더에 저장
             * 토크나이저로 꺼내서 인트형으로 변환 후 분해합 계산
             * 목표한 숫자랑 다를시 계속
             * 목표한 숫자랑 동일할시 정지
             */
            String cur_num = Integer.toString(str_num);
            int cur_num_sum = str_num;
            for(int i = 0; i < cur_num.length(); i++) {
                int digit = cur_num.charAt(i) - '0'; // 인트를 char로 바꾸면 아스키크도 화됨
                cur_num_sum += digit;               //"0" -> str형 '0' -> char형
            }
            if(cur_num_sum == N) {
                System.out.println(str_num);
                break;
            }
            str_num++;
        }

        System.out.println(sb);



        
    }

}
