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
 */
public class SWEA_1247_최적경로_NextPermutation {

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
    public static int[] customerNumberArray;
    public static void inputTestCase() throws IOException {

        // 2-1. 고객의 수를 입력받는다.
        st = new StringTokenizer(br.readLine().trim());
        customerCount = Integer.parseInt(st.nextToken());
        customerNumberArray = new int[customerCount];
        for (int index = 0; index < customerCount; index++) {
            customerNumberArray[index] = index;
        }

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

    public static void swap(int leftIndex, int rightIndex) {
        int temp = customerNumberArray[leftIndex];
        customerNumberArray[leftIndex] = customerNumberArray[rightIndex];
        customerNumberArray[rightIndex] = temp;
    }

    public static boolean hasNext() {
        int head = 0;
        int tail = customerCount - 1;

        // 맨 뒤부터 탐색해서 꼭대기를 찾는다.
        int highestElementIndex = tail; // 맨 뒤부터
        while(
                highestElementIndex > 0 && // 0이면 맨 앞이다.
                        customerNumberArray[highestElementIndex - 1] >= customerNumberArray[highestElementIndex] // 내 앞이 더 크면 다음 위치로
        ) {
            highestElementIndex--;
        }

        // 만약 꼭대기가 head에 위치하면 더 이상 만들 수 없음.
        if(highestElementIndex == head) {
            return false;
        }

        // 내림차순이 깨지는 위치보다 살짝 더 큰 위치를 찾는다.
        int brokenDescendingElementIndex = highestElementIndex - 1;
        int nextLargerThanBrokenElementIndex = tail;

        while(customerNumberArray[brokenDescendingElementIndex] >= customerNumberArray[nextLargerThanBrokenElementIndex]) {
            nextLargerThanBrokenElementIndex--;
        }


        // 두 위치를 서로 바꾼다.
        swap(brokenDescendingElementIndex, nextLargerThanBrokenElementIndex);

        // 내림차순을 오름차순으로 변경해서 사전 순으로 변경한다.
        int fairIndex = tail;
        while(highestElementIndex < fairIndex) {
            swap(highestElementIndex, fairIndex);
            highestElementIndex++;
            fairIndex--;
        }

        return true;
    }

    public static void nextPermutation() {

        do {
            int sumDistance = Math.abs(company.rowIndex - customers[customerNumberArray[0]].rowIndex) +
                    Math.abs(company.columnIndex - customers[customerNumberArray[0]].columnIndex);

            for(int customerNumberIndex = 0; customerNumberIndex < customerCount - 1; customerNumberIndex++) {
                sumDistance += Math.abs(customers[customerNumberArray[customerNumberIndex]].rowIndex - customers[customerNumberArray[customerNumberIndex + 1]].rowIndex) +
                        Math.abs(customers[customerNumberArray[customerNumberIndex]].columnIndex - customers[customerNumberArray[customerNumberIndex + 1]].columnIndex);
            }

            sumDistance += (Math.abs(customers[customerNumberArray[customerCount - 1]].rowIndex - home.rowIndex)
                    + Math.abs(customers[customerNumberArray[customerCount - 1]].columnIndex - home.columnIndex));

            minimumDistance = Math.min(minimumDistance, sumDistance);

        }while(hasNext());
    }

    public static int minimumDistance;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 1. 테스트 케이스 개수를 입력받는다.
        int testCaseCount = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc <= testCaseCount; tc++) {
            // 2. 각 테스트 케이스마다,
            inputTestCase();

            // 3. 방문할 고객의 순서를 결정한다.
            minimumDistance = Integer.MAX_VALUE;
            nextPermutation();

            sb.append("#").append(tc).append(" ").append(minimumDistance).append('\n');
        }
        System.out.println(sb);
    }
}
