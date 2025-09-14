import java.io.*;
import java.util.*;

public class practice {

    public static int[][] map;
    public static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int Node = Integer.parseInt(br.readLine());
        int Edge = Integer.parseInt(br.readLine());

        map = new int[Node + 1][Node + 1];
        for(int i = 1; i <= Node; i++) {
            for(int j =1; j <= Node; j++) {
                if(i == j) map[i][j] = 0;
                else {
                    map[i][j] = INF;
                }
            }
        }


        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], weight);
        }

        for(int mid = 1; mid <= Node; mid++) {
            for(int front = 1; front <= Node; front++) {
                for(int back = 1; back <= Node; back++) {
                    map[front][back] = Math.min(map[front][back], map[front][mid] + map[mid][back]);
                }
            }
        }

        for(int i = 1; i <= Node; i++) {
            for(int j = 1; j <= Node; j++) {
                if(map[i][j] == INF) {
                    sb.append("INF" + " ");
                }
                else {
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


