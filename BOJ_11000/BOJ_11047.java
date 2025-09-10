//BOJ_11047_동전_0

//package BOJ_11000;

import java.io.*;
import java.util.*;


public class BOJ_11047 {

    public static int[] money_size;
    public static int current_money;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int testcase_num = Integer.parseInt(st.nextToken());
        current_money = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        
        //동전 단위를 담을 배열 초기화
        money_size = new int[testcase_num];

        //배열에 동전의 단위를 담았고
        for(int i = 0; i < testcase_num; i++) {
            int money = Integer.parseInt(br.readLine());
            money_size[i] = money;
        }
        int money_length = money_size.length;
        for(int i = money_length - 1; i >= 0; i--) {
            int cur_money = current_money / money_size[i];
            answer += cur_money;

            current_money -= money_size[i] * cur_money;
        }

        System.out.println(answer);
    }

}
