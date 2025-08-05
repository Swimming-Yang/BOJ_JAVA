package BOJ_2300;

import java.io.*;
import java.util.*;

public class BOJ_2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr_length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Integer> balloons = new LinkedList<>();
        for (int i = 1; i <= arr_length; i++) {
            balloons.add(i);
        }
        
        int[] papers = new int[arr_length];
        for (int i = 0; i < arr_length; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        int currentIndex = 0;

        for (int j = 0; j < arr_length; j++) {

            int currentBalloon = balloons.remove(currentIndex);
            result.append(currentBalloon).append(" ");
            
            if (balloons.isEmpty()) break;
            
            int move = papers[currentBalloon - 1];
            
            if (move > 0) {
                currentIndex = (currentIndex + move - 1) % balloons.size();
            } else {  
                currentIndex = (currentIndex + move) % balloons.size();
                if (currentIndex < 0) {
                    currentIndex += balloons.size();
                }
            }
        }
        
        System.out.println(result.toString().trim()); //trim() == 앞 뒤 공백 제거
    }
}