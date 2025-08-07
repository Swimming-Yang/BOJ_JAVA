package BOJ_1100;

import java.io. *;
import java.util. *;

public class BOJ_1182 {
    static int N,
    S,
    count;
    static int[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) 
            count--;
        
        System
            .out
            .println(count);
    }

    static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 1. 현재 원소 포함
        dfs(index + 1, sum + arr[index]);

        // 2. 현재 원소 포함하지 않음
        dfs(index + 1, sum);
    }
}
