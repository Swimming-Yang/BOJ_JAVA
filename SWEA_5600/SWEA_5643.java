package SWEA_5600;

import java.io.*;
import java.util.*;

public class SWEA_5643 {
    public static int[][] map;
    public static int INF = 100_000_000;
    public static int count;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase_num = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testcase_num; t++) {
            count = 0;
            int Node = Integer.parseInt(br.readLine());

            map = new int[Node + 1][Node + 1];
            
            // 맵 초기화
            for(int j = 1; j <= Node; j++) {
                for(int k = 1; k <= Node; k++) {
                    if(j == k) {
                        map[j][k] = 0;  // 자기 자신
                    } else {
                        map[j][k] = INF;
                    }
                }
            }
            
            int Edge = Integer.parseInt(br.readLine());

            for(int j = 0; j < Edge; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map[start][end] = 1;  // start가 end보다 작다
            }

            // 플로이드 워셜
            for(int mid = 1; mid <= Node; mid++) {
                for(int fir = 1; fir <= Node; fir++) {
                    for(int end = 1; end <= Node; end++) {
                        map[fir][end] = Math.min(map[fir][end], map[fir][mid] + map[mid][end]);
                    }
                }
            }

            // 각 학생별로 순서를 알 수 있는지 확인
            for(int i = 1; i <= Node; i++) {
                int knowCount = 0;
                
                for(int j = 1; j <= Node; j++) {
                    if(i != j) {
                        // i보다 작은 학생이거나 i보다 큰 학생인 경우
                        if(map[i][j] != INF || map[j][i] != INF) {
                            knowCount++;
                        }
                    }
                }
                if(knowCount == Node - 1) {
                    count++;
                }
            }
            
            System.out.println("#" + t + " " + count);
        }
    }
}