//cspell:ignore SWEA, oper
//SWEA_3289_서로소 집합

package SWEA_3200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int[] parent;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            //초기화
            parent = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;  //make set
            }
            
            System.out.print("#" + t + " ");
            
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if(oper == 0) {
                    union(a, b);
                } else if(oper == 1) {
                    if(find(a) == find(b)) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
            }
            
            System.out.println();
        }
    }
    
    //Find
    public static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);  // 경로 압축
        }
        return parent[x];
    }
    
    //Union
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
