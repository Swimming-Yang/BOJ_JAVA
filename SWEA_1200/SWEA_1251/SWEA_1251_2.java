//*SWEA_1251_하나로_프림 */

package SWEA_1200.SWEA_1251;

import java.io.*;
import java.util.*;

/*
 * 문제를 푼 순서
 * 1. 입력값 구현하기
 * 2. 배열을 초기화 한 후 값 넣어주기
 * 3. 거리 계산 함수 추가하기
 * 4. 프림 함수 구현하기
 *  4.1 프림함수에서 사용할 방문배열, 최소비용 배열 초기화
 *  
 * 
 */

public class SWEA_1251_2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean visited[];
    //*섬의 x좌표들을 저장할 배열 */
    public static int[] loc_x;
    //*섬의 y좌표들을 저장할 배열 */
    public static int[] loc_y;
    public static double E;


    public static void main(String[] args) throws IOException{
        //* 가장 첫 줄은 전체 테스트 케이스의 수
        int testcase_num = Integer.parseInt(br.readLine());

        //* 각 테스트 케이스의 첫 줄에는 섬의 개수 N이 주어지고
        for(int i = 1; i <= testcase_num; i++) {
            int island_num = Integer.parseInt(br.readLine());
        //^ 초기화 영역
            loc_x = new int[island_num + 1];
            loc_y = new int[island_num + 1];


            //*두 번째 줄에는 각 섬들의 정수인 X 좌표 */
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= island_num; j++) {
                loc_x[j] = Integer.parseInt(st.nextToken());
            }

            //*세 번째 줄에는 각 섬들의 정수인 y 좌표 */
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= island_num; j++) {
                loc_y[j] = Integer.parseInt(st.nextToken());
            }

            //*마지막으로 해저 터널 건설의 환경 부담 세율 실수 E가 주어진다 */
            E = Double.parseDouble(br.readLine());

            double result = prim(island_num);
            System.out.println("#" + i + " " + Math.round(result));
        }
    }



    //^ 거리 계산 함수
    public static Double Distance(int a, int b) {
        double x = Math.pow((loc_x[a] - loc_x[b]), 2);
        double y = Math.pow((loc_y[a] - loc_y[b]), 2);

        double Distance_ab = x + y;
        double cost = Distance_ab * E;
        return cost;
    }

    //^ 프림 함수
    public static double prim(int island_num) {
        visited = new boolean[island_num + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        //* 1번 섬부터 시작
        pq.offer(new Node(1, 0));
        double totalCost = 0;
        
        //*큐가 빌 때까지 반복 */
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            
            //* 이미 방문했으면 건너뛰기
            if(visited[current.vertex]) continue;
            
            //* 방문 처리 및 비용 추가
            visited[current.vertex] = true;
            totalCost += current.cost;
            
            //* 모든 다른 섬들과의 거리 계산해서 큐에 추가
            for(int next = 1; next <= island_num; next++) {
                if(!visited[next]) {
                    double cost = Distance(current.vertex, next);
                    pq.offer(new Node(next, cost));
                }
            }
        }
        
        return totalCost;
    }
    static class Node implements Comparable<Node> {
        int vertex;
        double cost;

        public Node(int vertex, double cost) { 
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.cost, other.cost);
        }
    }




    }

