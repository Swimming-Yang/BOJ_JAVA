//BOJ_10798 세로읽기

import java.io.*;

public class BOJ_10798{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] lines = new String[5];
        int maxLength = 0;
        
        // 입력 받기
        for(int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
            maxLength = Math.max(maxLength, lines[i].length());
        }
        
        // 세로로 읽기
        for(int j = 0; j < maxLength; j++) {
            for(int i = 0; i < 5; i++) {
                if(j < lines[i].length()) {
                    sb.append(lines[i].charAt(j));
                }
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}