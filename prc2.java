import java.io.*;
import java.util.*;

public class prc2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] parent;

    public static int City_num;

static class Edge implements Comparable<Edge> {
    int end;
    int weight;

    Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
public static void main(String[] args) throws IOException{
    //*첫줄에 도시의 수 N이 주어진다 */
    int city_num = Integer.parseInt(br.readLine());
    //*둘쨋줄에 여행 계획에 속한 도시들의 수 M이 주어진다 */
    int travle_city = Integer.parseInt(br.readLine());
    //*다음 N개의 줄에는 N개의 정수가 주어진다 */
    for(int i = 0; i < city_num; i++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(end, weight));   
    }
    makeSet(city_num);
    Collections.sort(Edge);
    //*i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다. */

    //^출력 : 첫줄에 여행이 가능하면 YES, 아니면 NO를 출력한다./

}

public static void MakeSet(int a) {
    parent = new int[a + 1];
    for(int i = 0; i <= a; i++) {
        parent[i] = i;
        return;
    }
}

public static int FindSet(int a) { 
    if(parent[a] == a) {
        return a;
    }

    parent[a] = FindSet(parent[a]);
    return parent[a];
}

public static void Union(int a, int b) {
    int root_a = FindSet(a);
    int root_b = FindSet(b);

    if(root_a != root_b) {
        parent[root_b] = a;
    }
}
}