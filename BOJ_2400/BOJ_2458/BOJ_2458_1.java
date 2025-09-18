package BOJ_2400.BOJ_2458;

import java.io.*;
import java.util.*;

public class BOJ_2458_1 {

    public static boolean[][] map;

    public static int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        map = new boolean[Node + 1][Node + 1];

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = true;
        }

        
        for(int mid = 1; mid <= Node; mid++) {
            for(int str = 1; str <= Node; str++) {
                for(int end = 1; end <= Node; end++) {
                    if(map[str][mid] == true && map[mid][end]) map[str][end] = true;
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= Node; i++) {
            boolean checker = true;

            for(int j = 1; j <= Node; j++) {
                if(i != j) {
                    if(!map[i][j] && !map[j][i]) {
                    checker = false;
                    break;
                    }
                }
            }
            if(checker) count += 1;
        }
        System.out.println(count);
    }
}
