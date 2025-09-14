import java.io.*;
import java.util.*;

public class practice {

    public static ArrayList<Node> graph;
    public static int[] parents;

    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i < Edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.add(new Node(start, end, dist));
        }
        Collections.sort(graph);
        MakeSet(Node);

        int answer_weight = 0;
        int Edge_count = 0;

        for(Node node : graph) {
            if(FindSet(node.start) != FindSet(node.end)) {
                Union(node.start, node.end);
                answer_weight += node.weight;
                Edge_count += 1;

                if(Edge_count == Node - 1) break;
            }
        }


        for(int i = 0; i < Node; i++) {

        }
        System.out.println(answer_weight);
    }

    public static void MakeSet(int Node) {
        parents = new int[Node + 1];
        for(int i = 1; i <= Node; i++) {
            parents[i] = i;
        }
    }

    public static int FindSet(int x) {
        if(parents[x] == x) return x;
        parents[x] = FindSet(parents[x]);
        return parents[x];
    }

    public static void Union(int a, int b) {
        int root_a = FindSet(a);
        int root_b = FindSet(b);

        if(root_a != root_b) {
            parents[root_b] = root_a;
        }
    }
    
}


