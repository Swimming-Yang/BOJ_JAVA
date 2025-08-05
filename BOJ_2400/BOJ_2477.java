//BOJ_2477 참외밭
import java.io.*;
import java.util.*;

public class BOJ_2477 {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int fruit_num = Integer.parseInt(br.readLine());
       
       int[] dir = new int[6];
       int[] len = new int[6];
       
       int maxWidth = 0, maxHeight = 0;
       int maxWidthIdx = 0, maxHeightIdx = 0;
       
       // 입력받기
       for(int i = 0; i < 6; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           dir[i] = Integer.parseInt(st.nextToken());
           len[i] = Integer.parseInt(st.nextToken());
           

           if(dir[i] == 1 || dir[i] == 2) {  // 가로
               if(maxWidth < len[i]) {
                   maxWidth = len[i];
                   maxWidthIdx = i;
               }
           } else {
               if(maxHeight < len[i]) {
                   maxHeight = len[i];
                   maxHeightIdx = i;
               }
           }
       }
       
       int bigArea = maxWidth * maxHeight;
       

       int smallWidth = len[(maxWidthIdx + 3) % 6];
       int smallHeight = len[(maxHeightIdx + 3) % 6];
       int smallArea = smallWidth * smallHeight;
       
       int actualArea = bigArea - smallArea;
       

       int result = actualArea * fruit_num;
       
       System.out.println(result);
       br.close();
   }
}