import java.io.*;
import java.util.*;

public class Prac {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer> result;
    public static ArrayList<Integer> arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // Initialize
        result = new ArrayList<>();
        arr = new ArrayList<>();
        visited = new boolean[N];

        for(int i = 1; i <= N; i++) {
            arr.add(i);
        }

        permutation(0, R);
    }

    public static void permutation(int depth, int R) {
        // Base case
        if (depth == R) {
            for(int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if(i < result.size() - 1) {
                    System.out.print(" ");
                }
            }


            System.out.println();
            return;
        }

        for(int i = 0; i < arr.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                result.add(arr.get(i));

                permutation(depth + 1, R);

                result.remove(result.size() - 1);
                //visited[i] = false;
            }
        }
    }
}