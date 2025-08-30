import java.io.*;
import java.util.*;

public class Solution {

    static int T, K;
    static int[][] gears; // [4][8]

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(br.readLine().trim());
            gears = new int[4][8];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1; // 0-based
                int dir = Integer.parseInt(st.nextToken());
                applyRotation(idx, dir);
            }

            sb.append('#').append(tc).append(' ').append(score()).append('\n');
        }

        System.out.print(sb);
    }

    static int score() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (gears[i][0] << i);
        }
        return sum;
    }

    static void applyRotation(int start, int dir) {
        int[] rotateDir = new int[4];
        rotateDir[start] = dir;

        for (int i = start - 1; i >= 0; i--) {
            if (gears[i][2] != gears[i + 1][6]) rotateDir[i] = -rotateDir[i + 1];
            else break;
        }

        for (int i = start + 1; i < 4; i++) {
            if (gears[i - 1][2] != gears[i][6]) rotateDir[i] = -rotateDir[i - 1];
            else break;
        }

        for (int i = 0; i < 4; i++) {
            if (rotateDir[i] == 1) rotateClockwise(i);
            else if (rotateDir[i] == -1) rotateCounterClockwise(i);
        }
    }

    static void rotateClockwise(int idx) {
        int[] a = gears[idx];
        int temp = a[7];
        for (int i = 7; i >= 1; i--) a[i] = a[i - 1];
        a[0] = temp;
    }

    static void rotateCounterClockwise(int idx) {
        int[] a = gears[idx];
        int temp = a[0];
        for (int i = 0; i < 7; i++) a[i] = a[i + 1];
        a[7] = temp;
    }
}