/* 예제 1 : 숫자 뒤집기
 * 
 * 
 */

package Basic.형변환;

import java.io.*;
import java.util.*;

public class Number_Reverse {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        int num = Integer.parseInt(br.readLine()); //Int형으로 출력을 받은 후
        
        String str_num = String.valueOf(num);

        for(int i = str_num.length()-1; i >= 0; i--) {
            System.out.print(str_num.charAt(i));
        }
        System.out.println();
    }

}
