package BOJ_15600;

import java.io.*;
import java.util.*;

public class BOJ_15650 {
    
    static List<List<Integer>> result;
    static List<Integer> current;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        result = new ArrayList<>();
        current = new ArrayList<>();
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        
        combination(arr, 0, current, R);

        for(List<Integer> list : result) {
            for(int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public static void combination(int[] arr, int start, List<Integer> current, int R) {
        if(current.size() == R) {
            result.add(new ArrayList<>(current));
            return; 
        }
        
        for(int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            
            combination(arr, i + 1, current, R);
            
            current.remove(current.size() - 1);
        }
    }
}