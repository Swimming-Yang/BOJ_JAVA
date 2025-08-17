import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static ArrayList<Integer> [] graph; //연결정보담을 그래프
    public static boolean[] leafNode;

    public static int thief, police1, police2;

    public static void main(String[] args) throws IOException{
        int Node = Integer.parseInt(br.readLine()); //노드의 개수
        int Edge = Node - 1;

        graph = new ArrayList[Node + 1]; //리스트 초기화
        for(int i =0; i <= Node; i++) {
            graph[i] = new ArrayList<>();
        }

        leafNode = new boolean[Node + 1];


        for (int i = 0; i < Edge; i++) {//간선 정보 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end); //양방향이므로 양방향 정보 입력
            graph[end].add(start);
        }

        st = new StringTokenizer(br.readLine());
        int thief_loc = Integer.parseInt(st.nextToken());
        int police1_loc = Integer.parseInt(st.nextToken());
        int police2_loc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= Node; i++) { //리프노드는 연결된 간선이 1개
            if(graph[i].size() == 1) {
                leafNode[i] = true;
            }
        }

        thief = thief_loc;
        police1 = police1_loc;
        police2 = police2_loc;

        boolean result = canEscape(thief, police1, police2, 0); //도둑위치, 경찰1위치, 경찰2위치, 턴



        if(result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        
    }
        static boolean canEscape(int thiefCur, int police1Cur, int police2Cur, int turn) {

        //실패
        if (thiefCur == police1Cur || thiefCur == police2Cur) {
            return false; 
        }
        //성공
        if (leafNode[thiefCur]) {
            return true;
        }

        //도둑 턴
        if (turn == 0) {
            for(int next : graph[thiefCur]) {
                if (canEscape(next, police1Cur, police2Cur, 1)) { //재귀로 경찰 1에게 턴넘김
                    return true;
                }
            } return false; // 모든 경로실패 -> false
        } else if (turn == 1) {
        // 경찰1 턴
        for (int next : graph[police1Cur]) {
            if (!canEscape(thiefCur, next, police2Cur, 2)) { //재귀로 경찰 2에게 턴 넘김
                return false;
            }
        }
        return true;
    } else { // turn == 2
        // 경찰2 턴
        for (int next : graph[police2Cur]) {
            if (!canEscape(thiefCur, police1Cur, next, 0)) {//재귀로 경찰 3에게 턴 넘김
                return false;
            }
        }
        return true;
        }
    }
}