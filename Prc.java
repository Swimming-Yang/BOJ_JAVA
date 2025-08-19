import java.io.*;
import java.util.*;

public class Prc {
<<<<<<< Updated upstream

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Node>[] graph;
    public static int[] distance;
    public static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException{
        
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        //초기화 영역
        graph = new ArrayList[V + 1];
        distance = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);
    }
    
=======
    

>>>>>>> Stashed changes
}
