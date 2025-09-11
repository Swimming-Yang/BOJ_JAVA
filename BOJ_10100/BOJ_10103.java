package BOJ_10100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10103 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase_num = Integer.parseInt(br.readLine());
        int A = 100;
        int B = 100;
        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int turn_a = Integer.parseInt(st.nextToken());
            int turn_b = Integer.parseInt(st.nextToken());

            //*1. a가 b보다 작은경우 */
            if(turn_a < turn_b) {
                A -= turn_b;
                //System.out.println(A + "\n" + B);
            }
            //*2. b가 a보다 작은경우 */
            else if(turn_b < turn_a) {
                B -= turn_a;
                //System.out.println(A + "\n" + B);
            }
            else {
                continue;
            }
        }
        System.out.println(A + "\n" + B);
    }
}
