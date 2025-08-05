import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class BOJ_2444 {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        //N = 5;
        
        // 증가하는 별 (1번째 줄부터 N번째 줄까지)
        for(int i = 1; i <= N; i++) {
            int blank = N - i; 
            int star = 2 * i - 1;

            // 공백 출력
            for(int j = 0; j < blank; j++){
                sb.append(" ");
            }
            // 별 출력
            for(int k = 0; k < star; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 감소하는 별 (N-1번째 줄부터 1번째 줄까지)
        for (int i = N - 1; i >= 1; i--) {
            int blank = N - i; 
            int star = 2 * i - 1;
            
            // 공백 출력
            for(int j = 0; j < blank; j++){
                sb.append(" ");
            }
            // 별 출력
            for(int k = 0; k < star; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}