import java.io.*;
import java.util.*;

public class practice {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    //*parent 배열 */
    public static int[] parent;
    public static int[] rank;


    public static void main(String[] args) throws IOException{
        //*첫줄에 도시의 수 N 이 주어진다 */
        int N = Integer.parseInt(br.readLine());
        //*다음 줄에 여행 계획에 속한 도시들의 수 M이 주어진다 */
        int M = Integer.parseInt(br.readLine());

        makeSet(N);

        //*다음 N개의 줄에 N개의 정수가 주어진다(공백) */
        for(int i = 1 ; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int cur_city = Integer.parseInt(st.nextToken());

                if(cur_city == 1) {//*i번째도시와 현재도시(j번째 도시가 연결 되어 있다면) */
                    union(i, j); //*합쳐버리기 */
                }
            }
        }
        //*여행 계획 */
        st = new StringTokenizer(br.readLine());
        int first_city = Integer.parseInt(st.nextToken());
        int root_city = findSet(first_city);
        
        boolean canTravel = true;
        
        for(int i = 0; i < M - 1; i++) {
            int next_city = Integer.parseInt(st.nextToken());
            if(findSet(next_city) != root_city) {
                canTravel = false;
                break;
            }
        }
        
        if(canTravel) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
        //*도시들이 순서대로 주어졌을때 여행이 가능한지 여부를 판단 */

        //*여행가능 -> 그래프가 연결되어있다 -> 유니온파인드? */
        //*make set
        public static void makeSet(int N) {
            parent = new int[N + 1];
            rank = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                parent[i] = i; //* 자기 자신을 부모로 설정
                rank[i] = 0; //*첫 초기화시 랭크는 0
            }
        }
        //*fineSet
        public static int findSet(int x) {
            if (parent[x] == x) {
                return x;
            }

            parent[x] = findSet(parent[x]);
            return parent[x];
        }
        //*union
        public static void union(int a, int b) {
            int root_a = findSet(a);
            int root_b = findSet(b);

            if(rank[root_a] > rank[root_b]) {
                parent[root_b] = root_a;
            }
            else if(rank[root_b] > rank[root_a]) {
                parent[root_a] = root_b;
            }
            else if(rank[root_a] == rank[root_b]) {
                parent[root_b] = root_a;
                rank[root_a]++;
            }
        
        


        //*같은 도시를 여러번 방문하는 것도 가능
            }
}
