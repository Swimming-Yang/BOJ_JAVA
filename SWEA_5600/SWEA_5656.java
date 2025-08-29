//& SWEA_5656_벽돌깨기

package SWEA_5600;

import java.io.*;
import java.util.*;

public class SWEA_5656 {

    //*N개의 구슬로 가장많은 벽돌을 제거

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] graph;

    public static int N, W, H;

    public static void main(String[] args) throws IOException{

        //*가장 첫줄에는 총 테스트 케이스의 개수 T가 주어지고 */
        int testcase_num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= testcase_num; i++) {
            //*N - 구슬 사용횟수 W - 가로 H - 세로 */
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            graph = new int[H][W];
            int cur_block = 0;
            for(int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < W; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                    if(graph[j][k] != 0) {
                    cur_block += 1;
                    }
                }
            }

            
            int result = dfs(0, graph, cur_block);
            System.out.println("#" + i + " " + result);
            // Gravity(graph);
            // print(graph);
        }
        
    }

    //*구슬을 떨어트릴 DFS재귀 */
    public static int dfs(int depth, int[][] cur_graph, int cur_block) {
        if(depth == N) {
            return countBrick(cur_graph);
        }

        int answer = Integer.MAX_VALUE;
        //*col번째 열에 구슬을 떨어트리기 */
        for(int col = 0; col < W; col++) {
            int[][] copyGraph = new int[H][W];
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    copyGraph[i][j] = cur_graph[i][j];
                }
            }
            //*공을 떨어트리고 */
            dropBall(col, copyGraph);

            //*중력 처리
            Gravity(copyGraph);

            //*벽돌수 계산
            int newBricks = countBrick(copyGraph);

            //*다음 공으로 재귀
            int result = dfs(depth + 1, copyGraph, newBricks);
            
            //*최소값 갱신 */
            answer = Math.min(answer, result);
            //if(result == 3) print(copyGraph);
        }
        
        return answer;
    }

    public static void print(int[][] map){
        System.out.println("------------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void dropBall(int col, int[][] graph) {
        //*col번째 열에서 가장 위에 있는 벽돌 찾기 */
        for (int row = 0; row < H; row++) {
            if(graph[row][col] != 0) {
                breakBrick(row, col, graph);
                break;
            }
        }
    }
    public static void Gravity(int[][] graph) {
        for (int col = 0; col < W; col ++) {
            ArrayList<Integer> blocks = new ArrayList<>();
            //*해당 열의 0이아닌 벽돌들 순차적으로 저장 */
            for(int row = 0; row < H; row++) {
                if(graph[row][col] != 0) {
                    blocks.add(graph[row][col]);
                }
            }

            //*해당 열을 모두 0으로 초기화 */
            for(int row = 0; row < H; row++) {
                graph[row][col] = 0;
            }

            //*순차적으로 0이아닌 값 입력 */
            for(int i = 0; i < blocks.size(); i++) {
                graph[H - blocks.size() + i][col] = blocks.get(i);
            }
        }

    }

    public static void breakBrick(int row, int col, int[][] graph) {
        //*경계 체크 */
        //* 1. 맵안에 있는가
        //* 2. 이미 깨진벽돌인가
        if(row < 0 || row >= H || col < 0 || col >= W ) return;
        if(graph[row][col] == 0) return;

        //*깨진 벽돌의 힘 */
        int power = graph[row][col];
        
        //*대상 벽돌을 브레이크 */
        graph[row][col] = 0;

        for(int i = 1; i < power; i++) {
            //*상 */
            breakBrick(row - i, col, graph);
            //*하 */
            breakBrick(row + i, col, graph);
            //*좌 */
            breakBrick(row, col - i, graph);
            //*우 */
            breakBrick(row, col + i, graph);
        }
    }
    //*블록 개수 갱신 */
    public static int countBrick(int[][] graph) {
        int count = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(graph[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
