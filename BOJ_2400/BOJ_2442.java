package BOJ_2400;

import java.io.*;

public class BOJ_2442 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= num; i++) {
            int space = num - i;
            int star = i * 2 - 1;

            for(int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for(int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
