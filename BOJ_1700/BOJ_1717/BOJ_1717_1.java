package BOJ_1700.BOJ_1717;

import java.io.*;
import java.util.*;


public class BOJ_1717_1 {
    public static int[] parents;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        MakeSet(Node);

        for(int i = 0 ; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                Union(a, b);
            }
            else {
                if(FindSet(a) == FindSet(b)) System.out.println("YES");
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void MakeSet(int Node) {
        parents = new int[Node + 1];

        for(int i = 0 ; i <= Node; i++) {
            parents[i] = i;
        }
    }

    public static int FindSet(int x) {
        if(parents[x] == x) {
            return x;
        }
        
        parents[x] = FindSet(parents[x]);
        return parents[x];
    }

    public static void Union(int a, int b) {
        int root_a = FindSet(a);
        int root_b = FindSet(b);

        parents[root_b] = root_a;
    }

}
