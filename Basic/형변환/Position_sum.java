/*
 * 각자리수의 합을 구하는 코드
 */

package Basic.형변환;

import java.io.*;

public class Position_sum {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int basic_num = Integer.parseInt(br.readLine());
        int num_sum = 0;

        String str_num = String.valueOf(basic_num);

        for(int i = 0; i < str_num.length(); i++) {
            int cur_num = str_num.charAt(i) - '0';
            num_sum += cur_num;
        }

        System.out.println(num_sum);
        
        
    }

}
