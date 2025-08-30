//BOJ_1976_여행가자

package BOJ_1900;

import java.io.*;
import java.util.*;

public class BOJ_1976 {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) throws IOException{
        //*Node = 마을의 개수 
        int Node = Integer.parseInt(br.readLine());

        //*n = 여행에 속한 도시들의 수
        int n = Integer.parseInt(br.readLine());
        
        makeSet(Node);


        //*n개의 줄에 n개의 정수가 주어짐
        //*1번마을부터 n번마을까지 범위 재설정
        for(int i = 1; i <= Node; i++) {
            st = new StringTokenizer(br.readLine());
            //i번째줄의 j번째 수 
            for(int j = 1; j <= Node; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 1) { //* 각 마을이 연결되어있다면
                    union(i, j); //*유니온 파인드 진행
                }
            }
        }

        //마지막 여행 정보 읽기
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int first_Parent = findSet(first);

        boolean canTravel = true; //일단 트루로 초기화

        for(int i = 1; i < n; i++) {
            int cur_city = Integer.parseInt(st.nextToken());
            if(findSet(cur_city) != first_Parent) {
                canTravel = false;
                break;
            }
        }

        if(canTravel == true) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void makeSet(int Node) {
        parent = new int[Node + 1];
        rank = new int[Node + 1];

        for(int i = 1; i <= Node; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int findSet(int x) {
        // if(parent[x] != x) {
        //     parent[x] = findSet(parent[x]);
        // }
        // return parent[x];
        if(parent[x]== x) return x;

        parent[x] = findSet(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int root_a = findSet(a);
        int root_b = findSet(b);

        if(rank[root_a] > rank[root_b]) {
            parent[root_b] = root_a;
        }
        else if(rank[root_b] > rank[root_a]) {
            parent[root_a] = root_b;
        }
        else {
            parent[root_b] = root_a;
            rank[root_a]++;
        }
    }

}