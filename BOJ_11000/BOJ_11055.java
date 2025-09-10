import java.io.*;
import java.util.*;

public class BOJ_11055 {
    
    // Node 클래스: 값과 그 위치에서의 최대 합을 저장
    static class Node {
        int value;    // 수열의 값
        int maxSum;   // 이 값으로 끝나는 증가수열의 최대 합
        
        Node(int value, int maxSum) {
            this.value = value;
            this.maxSum = maxSum;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 의사코드: 이진탐색을 위한 동적 배열 생성 (Node 타입)
        // 설명: tails[i]는 길이가 i+1인 증가수열에서 마지막 값이 가장 작은 경우의 정보
        List<Node> tails = new ArrayList<>();
        
        // 의사코드: 전체 답을 저장할 변수 (모든 경우 중 최대값)
        int answer = 0;
        
        // 의사코드: 수열의 모든 원소에 대해 반복 처리
        for (int i = 0; i < n; i++) {
            // 의사코드: 현재 원소 값을 가져옴
            int currentValue = arr[i];
            
            // 의사코드: 현재 원소가 들어갈 위치를 이진탐색으로 찾음
            // 설명: currentValue보다 크거나 같은 첫 번째 위치를 찾음
            int pos = binarySearch(tails, currentValue);
            
            // 의사코드: 현재 원소로 끝나는 증가수열의 최대 합을 계산
            int currentSum;
            if (pos == 0) {
                // 의사코드: 맨 앞 위치라면 자기 자신만의 합
                currentSum = currentValue;
            } else {
                // 의사코드: 이전 위치의 최대 합에 현재 값을 더함
                currentSum = tails.get(pos - 1).maxSum + currentValue;
            }
            
            // 의사코드: 새로운 Node 객체 생성 (값과 최대 합 저장)
            Node newNode = new Node(currentValue, currentSum);
            
            if (pos == tails.size()) {
                // 의사코드: 가장 큰 값이면 배열 끝에 추가 (길이 증가)
                tails.add(newNode);
            } else {
                // 의사코드: 기존 위치를 새로운 더 나은 값으로 교체
                // 설명: 같은 길이에서 더 작은 값으로 끝나는 수열을 유지하거나 더 큰 합으로 갱신
                if (currentSum > tails.get(pos).maxSum || 
                    (currentSum == tails.get(pos).maxSum && currentValue < tails.get(pos).value)) {
                    tails.set(pos, newNode);
                }
            }
            
            // 의사코드: 현재까지의 최대 합을 갱신
            answer = Math.max(answer, currentSum);
        }
        
        // 의사코드: 최종 답 출력
        System.out.println(answer);
    }
    
    // Lower Bound 이진탐색 함수
    private static int binarySearch(List<Node> tails, int target) {
        // 의사코드: 탐색 범위의 시작점을 0으로 설정
        int left = 0;
        
        // 의사코드: 탐색 범위의 끝점을 배열 크기로 설정
        int right = tails.size();
        
        // 의사코드: 탐색 범위가 유효한 동안 반복
        while (left < right) {
            // 의사코드: 중간점 계산 (오버플로우 방지)
            int mid = left + (right - left) / 2;
            
            // 의사코드: 중간 위치의 값이 target보다 작으면
            if (tails.get(mid).value < target) {
                // 의사코드: target은 오른쪽 절반에 있으므로 left를 mid+1로 이동
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}