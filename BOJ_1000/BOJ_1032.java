package BOJ_1000;

import java.io.*;

public class BOJ_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase_num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] word_arr = new String[testcase_num];
        for (int i = 0; i < testcase_num; i++) {
            word_arr[i] = br.readLine();
        }

        for (int j = 0; j < word_arr[0].length(); j++) {
            char firstChar = word_arr[0].charAt(j);
            boolean same = true;

            for (int i = 1; i < testcase_num; i++) {
                if (word_arr[i].charAt(j) != firstChar) {
                    same = false;
                }
            }

            if (same == true) {
                sb.append(firstChar);
            } else {
                sb.append('?');
            }
        }
        System.out.println(sb);
        br.close();
    }

}