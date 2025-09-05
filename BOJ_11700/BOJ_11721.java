//&열 개씩 끊어 출력하기

package BOJ_11700;

import java.io.*;

public class BOJ_11721 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Word = br.readLine();

        for(int i = 0; i < Word.length(); i++) {
            if(i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(Word.charAt(i));
        }
        System.out.println();
    }
}
