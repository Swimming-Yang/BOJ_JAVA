//BOJ_11723_집합

package BOJ_11700;

import java.io.*;
import java.util.*;

public class BOJ_11723 {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static boolean[] list = new boolean[21];



    public static void main(String[] args) throws IOException{
        //비어있는 공집합 x
        sb = new StringBuilder();

        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase_num; i++) {
        st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        if(command.equals("add")) {
            int num = Integer.parseInt((st.nextToken()));
            list[num] = true;
        }
        else if(command.equals("remove")) {
            int num = Integer.parseInt((st.nextToken()));
            list[num] = false;
        }
        else if(command.equals("check")) {
            int num = Integer.parseInt((st.nextToken()));
            if(list[num] == true) {
                sb.append(1);
                sb.append("\n");
            } else {
                sb.append(0);
                sb.append("\n");
            }
        }
        else if(command.equals("toggle")) {
            int num = Integer.parseInt((st.nextToken()));
            if(list[num] == true) {
                list[num] = false;
            } else {
                list[num] = true;
            }
        }
        else if(command.equals("all")) {
            for(int j = 1; j < list.length; j++) {
                list[j] = true;
            }

        }
        else if(command.equals("empty")) {
            for(int j = 1; j < list.length; j++) {
                list[j] = false;
            }
        }
        }
        System.out.println(sb);

    }
}


