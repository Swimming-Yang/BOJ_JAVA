/*
 * BOJ_1197_최소스패닝트리 - 프림
 */

package BOJ_1100.BOJ_1197;

import java.io.*;
import java.util.*;

public class BOJ_1197_2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        //* 첫째 줄에 정점의개수 V와 간선의 개수 E가 주어진다.
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //* 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다 */
        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            
        }
    }

}
