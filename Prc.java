import java.io.*;
import java.util.*;

public class Prc {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] result; //결과 저장
    public static boolean[] visited; //방문 여부
    public static int[] arr; //대상 배열

    public static void main(String[] args) throws IOException{
        //nPr

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //배열 초기화
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt((st.nextToken()));
        }

        visited = new boolean[n];
        result = new int[r];   
        }

        permutation(0, R)

 
}
