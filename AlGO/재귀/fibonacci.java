package AlGO.재귀;

import java.io.*;

public class fibonacci {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int target_num = Integer.parseInt(br.readLine());
        
        int answer = fibonacci(target_num);
        System.out.println(answer);
    }

    public static int fibonacci(int n) {
        //Base Case : 종료 조건
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }

        //Reculsive Case : 반복 조건
        return(fibonacci(n - 1) + fibonacci(n - 2));
    }

}
