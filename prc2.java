import java.io.*;
import java.util.*;

public class prc2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int[][] graph;
    public static int[][] distance;

    public static int size;

    public static void main(String[] args) throws IOException{
        int testcase_num = Integer.parseInt(br.readLine());
        
        for(int testcase = 1; testcase <= testcase_num; testcase++) {
            size = Integer.parseInt(br.readLine());
            
            //초기화
            graph = new int[size][size];
            distance = new int[size][size];

            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }

            for(int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < size; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra(0, 0);

            System.out.println("#" + testcase + " " + distance[size - 1][size - 1]);
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y; //도착 정점
        int weight; //가중치

        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void dijkstra(int start_x, int start_y) {
        //우선순위 큐 사용 (가중치가 작은 순서대로 자동 정렬)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //시작 정점의 거리 0으로 설정
        distance[start_x][start_y] = 0;
        pq.offer(new Node(start_x, start_y, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int current_Weight = current.weight;

            //이미 더 가까운게 있으면 패스
            if (current_Weight > distance[current.x][current.y]) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < size && ny >= 0 && ny < size) {
                    int nextWeight = current.weight;

                    //가중치가 같을 때
                    if(graph[current.x][current.y] == graph[nx][ny]) {
                        nextWeight += 1;
                    }
                    //nx,y의 가중치가 클때
                    else if (graph[current.x][current.y] < graph[nx][ny]) {
                        nextWeight += ((graph[nx][ny] - graph[current.x][current.y]) * 2);
                    }
                    

                    if (nextWeight < distance[nx][ny]) {
                        distance[nx][ny] = nextWeight;
                        pq.offer(new Node(nx, ny, nextWeight));
                    }
                }
            }
        }
    }
}