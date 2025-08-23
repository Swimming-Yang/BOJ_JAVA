package BOJ_4100;

import java.io.*;
import java.util.*;

public class BOJ_4101 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 종료 조건을 먼저 체크
            if(A == 0 && B == 0) {
                break;
            }

            if(A > B) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}