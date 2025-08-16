//BOJ_1931 회의실 배정

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1931 {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static List<int[]> time_table;

    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());

        time_table = new ArrayList<>();

        for(int i = 0; i < testcase_num; i++) {
            st = new StringTokenizer(br.readLine());
            int str_time = Integer.parseInt(st.nextToken());
            int end_time = Integer.parseInt(st.nextToken());

            time_table.add(new int[] {str_time, end_time});
        }
        //람다식 공부해야할듯
        Collections.sort(time_table, (a, b) -> {
            if(a[1] == b[1]) {  // 끝시간이 같으면
                return a[0] - b[0];  // 시작시간 오름차순
            }
            return a[1] - b[1];  // 끝시간 오름차순
        });

        int answer = 0;
        int last_time = 0;

        for(int i = 0; i < time_table.size(); i++) {
            if(time_table.get(i)[0] >= last_time) {
                last_time = time_table.get(i)[1];
                answer += 1;
            }
        }

        System.out.println(answer);
    }

}
