package BOJ_1200;

import java.io.*;
import java.util.*;

public class BOJ_1205 {

    /** 점수를 저장할 배열 */
    public static ArrayList<Integer> score_List;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        /** 배열 초기화 */
        score_List = new ArrayList<>();

        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                score_List.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        score_List.add(newScore);

        Collections.sort(score_List, Collections.reverseOrder());

        int rank = score_List.indexOf(newScore) + 1;  // 등수는 1부터 시작

        int sameScore = 0;

        for(int score : score_List) {
            if(score == newScore) {
                sameScore++;
            }
        }

        // 변수명 통일: scoreList -> score_List
        if(rank > P || (score_List.size() > P && score_List.get(P-1) >= newScore)) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }

}