package BOJ_2400;


import java.io.*;

public class BOJ_2441 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            int star = num - i;
            int space = i;

            for(int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for(int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
