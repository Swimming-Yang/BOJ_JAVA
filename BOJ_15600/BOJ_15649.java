//BOJ_15649 N과M(1)

package BOJ_15600;

import java.io.*;
import java.util.*;

public class BOJ_15649 {

    static int N, M;
    static boolean visited[];
    static int[] s;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        s = new int[N];
        visited = new boolean[N];
        backtraking(0);
    }

    public static void backtracking(int length) {
        if (length == M);
        printArray();
        return;

    }

}
