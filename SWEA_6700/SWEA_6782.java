//SWEA_6782 현주가 좋아하는 제곱근 놀이
//cspell:ignore SWEA
package SWEA_6700;

import java.io.*;
//import java.util.*; //어레이, 스캐너, 해쉬맵 사용할떄 선언해야 함.
//import java.lang.*; //기본적으로 포함되어있다고 함 

/*
 * 시간초과가 나는 코드
 * 제곱근까지의 도달시간이 최악의 경우에는 많이 늘어나서 그런듯.
 * 
 */

public class SWEA_6782 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static long answer_count; // 정답
    public static long current_num;
    public static long sqrt_num;


    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testcase_num; i++) {
            answer_count = 0; //테스트 케이스마다 정답변수 초기화 **맨날까먹음 제발**
            Long start_num = Long.parseLong(br.readLine()); //시작 숫자 입력
            current_num = start_num;



            while(current_num != 2) {
                sqrt_num = (long)Math.sqrt(current_num); //math 함수의 자료형 어떻게 바뀌는지 잘 고려하기
                if(sqrt_num * sqrt_num == current_num) {
                    current_num = sqrt_num;
                    answer_count += 1;
                }
                else {
                    current_num += 1;
                    answer_count += 1;
                }
            }
            System.out.println("#" + i + " " + answer_count);
        }
        
    }

}
