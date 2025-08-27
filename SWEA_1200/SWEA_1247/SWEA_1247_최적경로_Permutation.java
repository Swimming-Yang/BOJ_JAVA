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
 * 2. 각 테스트 케이스 마다,
 *  2-1. 고객의 수를 입력받는다.
 *  2-2. 회사 좌표를 입력받는다.
 *  2-3. 집 좌표를 입력받는다.
 *  2-4. 각 고객들의 집 좌표를 입력받는다.
 *
 * 3. 방문할 고객의 순서를 결정한다. (순열 구현) --> 재귀 --> !! 기저조건
 *  3-1. 모든 고객의 순서를 결정했다면,
 *      3-1-1. 회수벝 첫 고객의 집까지 거리를 계산한다.
 *      ...
 *
 *
 *  3-2. 아직 순서를 결정하지 못했다면,
 *      3-2-1. 이미 선택한 고객이라면 제외.
 *      3-2-2. 아직 선택받지 못한 고객이라면 선택하고, 다음으로 넘어간다.
 *      3-2-3. 선택했던 고객을 선택 취소한다. (되돌려주기)
 *
 */
public class SWEA_1247_최적경로_Permutation {
    public static BufferedReader br;
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static class Customer {
        int rowIndex;
        int columnIndex;

        public Customer(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }

    public static int customerCount;
    public static int companyRowIndex, companyColumnIndex;
    public static int homeRowIndex, homeColumnIndex;
    public static Customer[] customerPointArray;
    public static void inputTestCase() throws IOException {

        // 2-1. 고객의 수를 입력받는다.
        st = new StringTokenizer(br.readLine().trim());
        customerCount = Integer.parseInt(st.nextToken());

        // 2-2. 회사 좌표를 입력받는다.
        st = new StringTokenizer(br.readLine().trim());
        companyRowIndex = Integer.parseInt(st.nextToken());
        companyColumnIndex = Integer.parseInt(st.nextToken());

        // 2-3. 집 좌표를 입력받는다.
        homeRowIndex = Integer.parseInt(st.nextToken());
        homeColumnIndex = Integer.parseInt(st.nextToken());

        // 2-4. 각 고객들의 집 좌표를 입력받는다.
        customerPointArray = new Customer[customerCount];
        for(int customerIndex = 0; customerIndex < customerCount; customerIndex++){
            customerPointArray[customerIndex] = new Customer(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                    );
        }
    }

    // selectIndex: 특정 고객을 선택해서 담을 위치
    public static void permutation(int selectIndex) {

        // 3-1. 모든 고객의 순서를 결정했다면,
        if(selectIndex == customerCount) {

            // 3-1-1. 회사부터 첫 고객의 집까지의 거리를 계산한다.
            int sumDistance = Math.abs(companyRowIndex - permuteCustomerArray[0].rowIndex) +
                    Math.abs(companyColumnIndex - permuteCustomerArray[0].columnIndex);

            // 3-1-2. 각 고객들의 거리를 계산한다.
            for(int customerIndex = 0; customerIndex < customerCount - 1; customerIndex++) {

                Customer customer = customerPointArray[customerIndex];
                Customer nextCustomer = customerPointArray[customerIndex + 1];

                sumDistance += (
                        Math.abs(customer.rowIndex - nextCustomer.rowIndex) +
                                Math.abs(customer.columnIndex - nextCustomer.columnIndex)
                );
            }

            // 3-1-3. 마지막 고객과 집까지의 거리를 계산한다.
            sumDistance += Math.abs(companyRowIndex - permuteCustomerArray[customerCount - 1].rowIndex) +
                    Math.abs(companyColumnIndex - permuteCustomerArray[customerCount - 1].columnIndex);

            // 3-1-4. 최소 거리를 갱신한다.
            minimumDistance = Math.min(minimumDistance, sumDistance);
            return;
        }

        // 3-2. 아직 순서를 결정하지 못했다면,
        for(int customerIndex = 0; customerIndex < customerCount; customerIndex++) {
            // 3-2-1. 이미 선택한 고객이라면 제외.
            if(selectedCustomer[customerIndex]) {
                continue;
            }

            // 3-2-2. 아직 선택받지 못한 고객이라면 선택하고, 다음으로 넘어간다.
            selectedCustomer[customerIndex] = true;
            permuteCustomerArray[selectIndex] = customerPointArray[customerIndex];
            permutation(selectIndex + 1); // +1

            // 3-2-3. 선택했던 고객을 선택 취소한다. (되돌려주기)
            selectedCustomer[customerIndex] = false;
        }

    }


    public static int minimumDistance;
    public static boolean[] selectedCustomer; // 순열을 구성하는데 해당 고객을 선택했는지
    public static Customer[] permuteCustomerArray; // 선택해서 담아둘 배열
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 1. 테스트 케이스 개수를 입력받는다.
        int testCaseCount = Integer.parseInt(br.readLine().trim()); // .trim() 습관화!
        for(int tc = 1; tc <= testCaseCount; tc++) {

            // 2. 각 테스트 케이스 마다,
            inputTestCase();

            // 3. 방문할 고객의 순서를 결정한다.
            minimumDistance = Integer.MAX_VALUE; // 항상 초기화!! // MAX 값인 이유는? 최솟값을 찾으려고!
            selectedCustomer = new boolean[customerCount];
            permuteCustomerArray = new Customer[customerCount];
            permutation(0);
        }
    }

}
