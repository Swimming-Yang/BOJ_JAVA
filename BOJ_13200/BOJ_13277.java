package BOJ_13200;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class BOJ_13277 { // 백준 13277번 큰 수 곱셈 문제

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String strA = st.nextToken();
        String strB = st.nextToken();

        BigInteger numA = new BigInteger(strA);
        BigInteger numB = new BigInteger(strB);

        BigInteger answer = numA.multiply(numB);
        System.out.println(answer);
    }
}