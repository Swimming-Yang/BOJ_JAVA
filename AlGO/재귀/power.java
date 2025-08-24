//재귀의 거듭제곱

package AlGO.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class power {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int power_num = Integer.parseInt(st.nextToken());

        int answer = power_cul(num, power_num);
        System.out.println(answer);
    }


    public static int power_cul(int num, int power_num) {
        //Base Code
        if(power_num == 0) {
            return 1;
        }
        if(power_num == 1) {
            return num;
        }

        //Reculsive Code
        return num * power_cul(num, power_num - 1);
    }

}
