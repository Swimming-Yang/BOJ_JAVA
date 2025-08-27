//*SWEA_1251_하나로 - 크루스칼 */
//cspell:ignore SWEA
package SWEA_1200.SWEA_1251;

import java.io.*;
import java.util.*;
//* N개의 섬들을 연결하는 프로젝트*/
//* 환경 부담 세율 = E */
//* 해저 터널의 길이 = L */
//* 환경 부담금 = (E * (L^2)) */
//* 총 환경 부담금을 최소로 하며, N개의 모든 섬을 연결할 수 있는 교통 시스템을 설계*/
public class SWEA_1251_1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] parent;
    public static int[] loc_x;
    public static int[] loc_y;

    public static void main(String[] args) throws IOException{
        //*가장 첫 줄 은 전체 테스트 케이스의 수이다
        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= testcase_num; i++) {
            //*각 테스트 케이스의 첫 줄에는 섬의 개수 N이 주어지고 */
            int island_num = Integer.parseInt(br.readLine());

            makeSet(island_num);

            //*두 번째 줄에는 각 섬들의 정수인 x 좌표 */
            st = new StringTokenizer(br.readLine());
            loc_x = new int[island_num + 1];
            for(int k = 1; k <= island_num; k++) {
                loc_x[k] = Integer.parseInt(st.nextToken());
            }


            //*세 번째 줄에는 각 섬들의 정수인 y 좌표가 주어진다
            st = new StringTokenizer(br.readLine());
            loc_y = new int[island_num + 1];
            for(int k = 1; k <= island_num; k++) {
                loc_y[k] = Integer.parseInt(st.nextToken());
            }

            //*마지막으로 해저터널 건설의 환경 부담 세율 실수 E가 주어진다
            double E = Double.parseDouble(br.readLine());       
            
            //*간선을 생성해 보아요
            //*간선 생성 전에 리스트를 선언해 보아요 */
            ArrayList<Edge> edges = new ArrayList<>(); //*edges에는 a, b, 코스트가 저장 될 예정 */

            for(int k = 1; k <= island_num; k++) {
                for(int l = k + 1; l <= island_num; l++) {
                    double Distance = Distance(k, l);
                    double cost = E * Math.pow(Distance, 2);
                    edges.add(new Edge(k, l, cost)); //*새로운 Edge에는 k번째섬과 l번째섬, 두섬의 거리비용이 들어감 */
                }
            }

            // 간선들을 비용 순으로 정렬
            Collections.sort(edges);

            // 크루스칼 알고리즘 실행
            double totalCost = 0;
            int selectedEdges = 0;

            for(Edge edge : edges) {
                //* 이 간선을 선택해도 사이클이 생기지 않는가?
                if(findSet(edge.island_a) != findSet(edge.island_b)) {
                    //* 사이클이 안 생기니까 선택!
                    union(edge.island_a, edge.island_b);
                    totalCost += edge.cost;
                    selectedEdges++;
                    
                    //* MST는 N-1개의 간선이 필요
                    if(selectedEdges == island_num - 1) break;
                }
            }
            System.out.println("#" + i + " " + String.format("%.0f", totalCost));
        }
    }

        //*일단 모든 섬을 분리해볼까
        public static void makeSet(int island_num) {
            parent = new int[island_num + 1];
            for(int j = 1; j <= island_num; j++) {
                parent[j] = j; //*자기 자신을 일단 루트노드로 설정 */
            }
        }

        public static int findSet(int x) {
            if(parent[x] == x) {
                return(x);
            }

            parent[x] = findSet(parent[x]);
            return(parent[x]);
        }

        public static void union(int a, int b) {
            //*루트 초기화
            int root_a = findSet(a);
            int root_b = findSet(b);

            //*두 섬의 루트가 같을 경우 */
            //*이경우에는 그냥 다를때 노드상관없이 붙여주기만 하면됨. */
            if(root_a != root_b) {
                parent[root_b] = root_a;
            }
            
        }

        //*두 섬 사이의 거리를 계산하는 함수 */
        //*거리 =  */
        public static double Distance(int island_a, int island_b) {
            double part_a = Math.pow((loc_x[island_a] - loc_x[island_b]), 2);
            double part_b = Math.pow((loc_y[island_a] - loc_y[island_b]), 2);

            double Distance_ab = Math.sqrt(part_a + part_b);
            return Distance_ab;
        }

        //*Edge class */
        public static class Edge implements Comparable<Edge> {
            int island_a, island_b; double cost;

            public Edge(int island_a, int island_b, double cost) {
                this.island_a = island_a;
                this.island_b = island_b;
                this.cost = cost;
            }

            @Override
            public int compareTo(Edge other) {
                return Double.compare(this.cost, other.cost);
            }

        }
    }

