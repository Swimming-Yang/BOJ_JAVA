//BOJ_1874_스텍수열


package BOJ_1800;

import java.io.*;
import java.util.*;

public class BOJ_1874 {
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static StringBuilder sb;

public static void main(String[] args) throws IOException{

    sb = new StringBuilder();

    Stack<Integer> stack = new Stack<>(); //숫자를 담을 스택

    int testcase_num = Integer.parseInt(br.readLine()); //들어갈 숫자 1 ~ testcase_num

    int start = 1; //시작 숫자 1부터 n까지

    for(int i = 0; i < testcase_num; i++) {

        int target = Integer.parseInt(br.readLine()); //현재 출력해야할 숫자
        
        if(target >= start) { //뽑아야할 숫자가 현재숫자보다 작다면
            for(int j = start; j <= target; j++) {
                stack.push(j); //뽑아야할 자까지 스텍에 저장
                sb.append('+').append('\n'); //저장하니 "+" + 줄바꿈
        }

        start = target + 1; //다음 숫자를 찾기위해 초기화

    } else if (stack.peek() != target) { //뽑아야할 숫자가 현재 숫자보다 크다면
        System.out.println("NO"); //출력 불가
        return;
    }


    //타켓이 스택 제일 위에 있음 
    stack.pop();
    sb.append('-').append('\n');
    
        }
    System.out.println(sb);
    }
}
