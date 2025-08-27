package SWEA_1200.SWEA_1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SW Expert Academy
 * @author sahong.pak
 *
 * 1. 테스트 케이스 개수를 입력받는다.
 * 2. 각 테스트 케이스마다,
 *  2-1. 고객의 수를 입력받는다.
 *  2-2. 회사 좌표를 입력받는다.
 *  2-3. 집 좌표를 입력받는다.
 *  2-4. 고객들의 집 좌표를 입력받는다.
 *
 *
 * 집 -> 고객1 -> 고객 2-> 고객 3 -> 집
 * 000, 001, 010, 100, 011, 101, 110, 111 => 비트 마스킹으로 고객 방문 체크.
 *
 * 3. 최소 거리를 계산한다. (DP)
 *  3-1. 각 거리를 무한대로 초기화한다.
 *  3-2. 회사에서 각 고개 별 거리를 계산한다.
 *  3-3. 각 방문 조합마다 00001(1)부터 11111(31)까지
 *      3-3-1. 방문 조합에 포함되어있지 않으면 제외.
 *      3-3-2. 해당 방문 조합 중에 포함되어있지 않은 고객을 찾는다.
 *          3-3-2-1. 방문 조합에 포함되어있다면 제외. => 새로 방문해 볼 곳.
 *          3-3-2-2. 다음 방문 고객까지 포함하여 새로운 방문 조합을 생성한다.
 *          3-3-2-3. 다음 방문 고객까지의 거리를 포함하여 거리를 계산한다.
 *          3-3-2-4. 새로운 방문 조합에서 다음 고객으로 이동할 때 거리가 최소인 것으로 갱신한다.
 *
 *  3-4. 모든 결과 중에서 거리가 최소인 값을 찾는다.
 *
 * 4. 최소 거리를 출력한다.
 *
 */
public class SWEA_1247_최적경로_DP {

    public static BufferedReader br;
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static class Point {
        int rowIndex;
        int columnIndex;

        public Point(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }

    public static int customerCount;
    public static Point company, home;
    public static Point[] customers;
    public static void inputTestCase() throws IOException {

        // 2-1. 고객의 수를 입력받는다.
        st = new StringTokenizer(br.readLine().trim());
        customerCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        // 2-2. 회사 좌표를 입력받는다.
        company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        // 2-3. 집 좌표를 입력받는다.
        home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        //  2-4. 고객들의 집 좌표를 입력받는다.
        customers = new Point[customerCount];
        for(int customerIndex = 0; customerIndex < customerCount; customerIndex++) {
            customers[customerIndex] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    public static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.rowIndex - p2.rowIndex) + Math.abs(p1.columnIndex - p2.columnIndex);
    }

    public static void findMinimumDistance() {

        // 3-1. 각 거리를 무한대로 초기화한다.
        for(int rowIndex = 0; rowIndex < (1 << customerCount); rowIndex++) {
            for(int columnIndex = 0; columnIndex < customerCount; columnIndex++) {
                distance[rowIndex][columnIndex] = Integer.MAX_VALUE; // INF
            }
        }

        // 3-2. 회사에서 각 고개 별 거리를 계산한다.
        //              0    1    2    3    4    // 고객 (마지막 도착 고객이라 생각)
        // (1)  00001  110   X    X    X    X
        // (2)  00010   X   40    X    X    X
        // ...
        // (4)  00100   X    X   15    X    X
        // ...
        // (8)  01000   X    X   X    160   X
        // ...
        // (16) 10000   X    X   X     X   70
        for(int customerIndex = 0; customerIndex < customerCount; customerIndex++) {
            distance[1 << customerIndex][customerIndex] = getDistance(company, customers[customerIndex]);
        }

        // 3-3. 각 방문 조합마다 00001(1)부터 11111(31)까지
        for(int visitedSet = 1; visitedSet < (1 << customerCount); visitedSet++) {
            for(int fromCustomerIndex = 0; fromCustomerIndex < customerCount; fromCustomerIndex++) {

                // 3-3-1. 방문 조합에 포함되어있지 않으면 제외.
                if((visitedSet & (1 << fromCustomerIndex)) == 0) {
                    continue;
                }

                // 3-3-2. 해당 방문 조합 중에 포함되어있지 않은 고객을 찾는다.
                for(int toCustomerIndex = 0; toCustomerIndex < customerCount; toCustomerIndex++) {

                    // 3-3-2-1. 방문 조합에 포함되어있다면 제외. => 새로 방문해 볼 곳.
                    if((visitedSet & (1 << toCustomerIndex)) != 0) { // 0이 아니다!!
                        continue;
                    }

                    // 3-3-2-2. 다음 방문 고객까지 포함하여 새로운 방문 조합을 생성한다.
                    int newVisitedSet = visitedSet | (1 << toCustomerIndex);

                    // 3-3-2-3. 다음 방문 고객까지의 거리를 포함하여 거리를 계산한다.
                    int newDistance = distance[visitedSet][fromCustomerIndex] + getDistance(customers[fromCustomerIndex], customers[toCustomerIndex]);

                    // 3-3-2-4. 새로운 방문 조합에서 다음 고객으로 이동할 때 거리가 최소인 것으로 갱신한다.
                    distance[newVisitedSet][toCustomerIndex] = Math.min(distance[newVisitedSet][toCustomerIndex], newDistance);
                }
            }
        }

        // 3-4. 모든 결과 중에서 거리가 최소인 값을 찾는다.
        minimumDistance = Integer.MAX_VALUE;
        int allVisited = (1 << customerCount) - 1; // 모든 비트가 1인 경우 => 모든 고객을 방문 완료. => 각 고객마다 마지막으로 방문한 경우들이 완료.

        for(int customerIndex = 0; customerIndex < customerCount; customerIndex++) {
            if(distance[allVisited][customerIndex] == Integer.MAX_VALUE) { // 불가능한 경우가 아니라면 거리 계산이 되어있는 것.
                continue;
            }

            minimumDistance = Math.min(
                    minimumDistance, // 기존에 찾은 최소 거리와
                    distance[allVisited][customerIndex] + getDistance(customers[customerIndex], home) // 새로 계산한 거리 중에서
            ); // 더 최소인 거리로 갱신한다.
        }

    }

    public static int[][] distance;
    public static int minimumDistance;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 1. 테스트 케이스 개수를 입력받는다.
        int testCaseCount = Integer.parseInt(br.readLine().trim());
        for(int testCase = 1; testCase <= testCaseCount; testCase++) {

            // 2. 각 테스트 케이스마다,
            inputTestCase();

            // 3. 최소 거리를 계산한다. (DP)
            distance = new int[1 << customerCount][customerCount];
            findMinimumDistance();

            // 4. 최소 거리를 출력한다.
            sb.append("#").append(testCase).append(" ").append(minimumDistance).append('\n');
        }
        System.out.println(sb);
    }
}
