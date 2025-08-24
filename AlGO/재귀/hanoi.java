package AlGO.재귀;

import java.io.*;
import java.util.*;

public class hanoi {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int height = Integer.parseInt(br.readLine());

        int answer = hanois(height, 1, 2, 3);
    }

    public static int hanois(int height, int first, int second, int third) {
        //base Part - 종료조건


        //Reculsive Part - 재귀조건
        //1, 2번탑에 블록이 남아있다면?
    }

}
