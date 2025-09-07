package BOJ_5500;

import java.io.*;
import java.util.*;

public class BOJ_5522 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i = 0 ; i < 5; i++) {
            int cur_num = Integer.parseInt(br.readLine());
            answer += cur_num;
        }

        br.close();
        System.out.println(answer);
    }

}
