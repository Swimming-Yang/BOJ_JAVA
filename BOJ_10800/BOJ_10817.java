//BOJ_10817 세 수

package BOJ_10800;

import java.io.*;
import java.util.*;
public class BOJ_10817 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<Integer>();

        int num_1 = Integer.parseInt(st.nextToken());
        list.add(num_1);
        int num_2 = Integer.parseInt(st.nextToken());
        list.add(num_2);
        int num_3 = Integer.parseInt(st.nextToken());
        list.add(num_3);

        list.sort(null);
        int answer = list.get(1);
        System.out.println(answer);
    }
}

