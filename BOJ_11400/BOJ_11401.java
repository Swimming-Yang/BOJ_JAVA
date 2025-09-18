//&이항 계수3
package BOJ_11400;

import java.io.*;
import java.util.*;

public class BOJ_11401 {

    public static final long P = 1000000007;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long bunja = factorial(A);
        long bunmo = factorial(B) * factorial(A - B) % P;

        System.out.println(bunja * pow(bunmo, P - 2) % P);
    }

    public static long factorial(long N) {
    long fac = 1L;

    while(N > 1) {
        fac = (fac * N) % P;
        N--;
    }
        return fac;
    }

    public static long pow(long base, long expo) {
        long result = 1;

        while (expo > 0) {
            if(expo % 2 == 1) {
                result *= base;
                result %= P;
            }
            base = (base * base) % P;
            expo /= 2;
        }
        return result;
    }
}


