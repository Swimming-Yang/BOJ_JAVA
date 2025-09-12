//&BOJ_13300 방배정

package BOJ_13300;

import java.io.*;
import java.util.*;

public class BOJ_13300 {

    public static int[][] people;
    public static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int person = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        
        people = new int[2][7];
        for(int i = 0; i < person; i++) {
            st = new StringTokenizer(br.readLine());
            int Sex = Integer.parseInt(st.nextToken());
            int Grade = Integer.parseInt(st.nextToken());

            people[Sex][Grade] += 1;
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= 6; j++) {
                if(people[i][j] % max == 0) {
                    answer += people[i][j] / max;
                }

                else{
                    answer += (people[i][j] / max) + 1;
                }
            }
        }

        System.out.println(answer);


        
    }

}
