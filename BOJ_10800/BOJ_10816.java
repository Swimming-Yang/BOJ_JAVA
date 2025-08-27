//BOJ_10816_숫자카드2

package BOJ_10800;

import java.io.*;
import java.util.*;

public class BOJ_10816 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        int cardCount = Integer.parseInt(br.readLine());
        
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cardCount; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
        }

        int queryCount = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < queryCount; i++) {
            int query = Integer.parseInt(st.nextToken());
            
            int count = cardMap.getOrDefault(query, 0);
            
            sb.append(count);
            if(i < queryCount - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}