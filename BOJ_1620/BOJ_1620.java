//BOJ_1620 나는야 포켓몬 마스터

package BOJ_1620;

import java.io.*;
import java.util.*;

public class BOJ_1620 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] num_list;
    public static String[] poke_list;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int p_num = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        //초기화

        num_list = new int[p_num + 1];
        poke_list = new String[p_num + 1];

        for(int i = 1; i <= p_num; i++) {
            String poke = br.readLine();
            poke_list[i] = poke;
        }

        for(int i = 1; i <= p_num; i++) {
            num_list[i] = i;
        }

        for(int i = 0; i < question; i++) {
            String input = br.readLine();

            if(Character.isDigit(input.charAt(0))) {
                //숫자인 경우
                int num = Integer.parseInt(input);
                System.out.println(poke_list[num]);
            }

            else {
                for(int j = 1; j <= p_num; j++) {
                    if(poke_list[j].equals(input)) {
                        System.out.println(j);
                        break;
                    }
                }
            }
        }

        
    }

}
