//BOJ_2477 참외밭

import java.io.*;
import java.util.*;

public class BOJ_2477 {
 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int fruit_num = Integer.parseInt(br.readLine());
        
        int[] dir = new int[6];   // 방향 배열
        int[] len = new int[6];   // 길이 배열
        
        int maxWidth = 0, maxHeight = 0;      // 최대 가로, 세로
        int maxWidthIdx = 0, maxHeightIdx = 0; // 최대값들의 인덱스
        
        // 입력받기
        for(int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            
            // 1,2: 동서(가로), 3,4: 남북(세로)
            if(dir[i] == 1 || dir[i] == 2) {  // 가로
                if(maxWidth < len[i]) {
                    maxWidth = len[i];
                    maxWidthIdx = i;
                }
            } else {  // dir[i] == 3 || dir[i] == 4, 세로
                if(maxHeight < len[i]) {
                    maxHeight = len[i];
                    maxHeightIdx = i;
                }
            }
        }
        
        // 큰 사각형 넓이
        int bigArea = maxWidth * maxHeight;
        
        // 작은 사각형의 가로, 세로 구하기
        // 최대 가로의 반대편에 있는 길이가 작은 사각형의 가로
        // 최대 세로의 반대편에 있는 길이가 작은 사각형의 세로
        int smallWidth = len[(maxWidthIdx + 3) % 6];
        int smallHeight = len[(maxHeightIdx + 3) % 6];
        int smallArea = smallWidth * smallHeight;
        
        // 실제 넓이 = 큰 사각형 - 작은 사각형
        int actualArea = bigArea - smallArea;
        
        // 총 참외 개수
        int result = actualArea * fruit_num * 7;
        
        System.out.println(result);
        br.close();
    }

}
