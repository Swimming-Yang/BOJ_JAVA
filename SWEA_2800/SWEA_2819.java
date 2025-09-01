//& SWEA_2819 격자판의 숫자 이어 붙이기

package SWEA_2800;

import java.io.*;
import java.util.*;

public class SWEA_2819 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[][] map;
    
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static HashSet<String> word;

    /*
     * 격자판의 임의의 위치에서 시작해서 동서남북 네 방향으로 인접한 격자로 총 6번 이동
     * 각 칸의 적혀있는 수를 이어붙이면 7자리 수가 됨.
     * 격자 판을 벗어나는 이동은 가능하지 않음.(이동시 경곗값 필요)
     * 
     * 아아.. 이것은 hashSet이라는 물건이다.. 
     * 자동으로 중복을 제거해주는 물건이지 ..
     */

    public static void main(String[] args) throws IOException{

        int testcase_num = Integer.parseInt(br.readLine());

        word = new HashSet<>();

        for(int i = 1; i <= testcase_num; i++) {
            word.clear();
            map = new int[4][4];
            for(int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 4; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            //*모든 정점에서 출발이 가능하다 했으므로 모든 구간에서 dfs */
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    String map_word = String.valueOf(map[j][k]);
                    dfs(j, k, 1, map_word);
                }
            }
            System.out.println("#" + i +  " " + word.size());
        }

    }

    public static void dfs(int x, int y, int depth, String map_word) {

        //^종료 조건
        if(depth == 7) {
            word.add(map_word);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            String new_word = String.valueOf(map[nx][ny]);
            
            if(nx >= 0 &&nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx, ny, depth + 1, map_word + new_word);
            }
        }
    }
}
