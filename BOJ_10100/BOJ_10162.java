package BOJ_10100;

import java.io.*;
import java.util.*;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //*5분 -> 300초*/
        int BA = 0;

        //*1분  -> 60초*/
        int BB = 0;

        //*10초  - > 10초*/
        int BC = 0;
        int time = Integer.parseInt(br.readLine());

        BA = time / 300;
        sb.append(BA + " ");
        int cur_time = time - BA * 300;
        BB = cur_time / 60;
        sb.append(BB + " ");
        cur_time = cur_time - BB * 60;

        BC = cur_time / 10;
        sb.append(BC + " ");

        int total = BA * 300 + BB * 60 + BC * 10;
        if(total == time) {
            System.out.println(sb);
        }
        else {
            System.out.println(-1);
        }
    }

}
