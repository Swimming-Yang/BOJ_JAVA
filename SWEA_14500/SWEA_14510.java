<<<<<<< Updated upstream
package SWEA_14500;

import java.io.*;
import java.util.*;

public class SWEA_14510 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int[] tree_list;
	public static int[] new_tree_list;//나무를 저장할 배열
	public static int one, two; //1, 2일차를 비교할 배열
	public static int answer;
	public static int cur_tree; //반복에서 현재 나무를 저장할 변수

	public static void main(String[] args) throws IOException{
		int testcase_num = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testcase_num; i++) {
			int tree_num = Integer.parseInt(br.readLine());
			
			//그래프 초기화
			tree_list = new int[tree_num];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < tree_list.length; j++) {
				tree_list[j] = Integer.parseInt(st.nextToken());
			}
			
			//날짜를 저장할 변수
			one = 0;
			two = 0;
			
			//최대 나무
			int max_tree = Integer.MIN_VALUE;
			for(int j = 0; j < tree_num; j++) {
				if(tree_list[j] > max_tree) {
					max_tree = tree_list[j];
				}
			}
			//System.out.println("최대나무" + max_tree); //최대나무 입력확인
			
			//각 나무에 필요한 날짜 계산
			for(int j = 0; j < tree_num; j++) {
				cur_tree = tree_list[j];
				int chai = max_tree - cur_tree;
				
				if(tree_list[j] == max_tree) {
					continue;
				}
				
				one += (chai) % 2;
				two += (chai) / 2;
			}
			
			
			while(two > one + 1 && two > 0) {
				one += 2;
				two--;
			}
			
			if (one > two) {
				answer = one * 2 - 1;
			} else if (one < two) {
				answer = two *2;
			} else if (one == two) {
				answer = one + two;
			}
			
			System.out.println("#" + i + " " + answer);
		}//테스트케이스	
	}//메인
}//클래스



=======
//cspell: ignore SWEA

package SWEA_14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 14150. 나무 높이
 * @category 그리디
 */
public class SWEA_14510 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int max = 0; //가장 큰 나무의 높이
			int[] trees = new int[N];
			for (int i = 0; i < N; i++) {
				int t = Integer.parseInt(st.nextToken());
				trees[i] = t;
				
				max = Math.max(max, t);
			}
			
			//나무가 자라야 할 높이에서 필요한 1, 2의 개 수 구하기
			int even = 0, odd = 0;
			for (int i = 0; i < N; i++) {
				int diff = max - trees[i];
				
				if(diff == 0) continue;
				
				even += diff / 2;
				odd += diff % 2;
			}
			
			//2 -> 1로 변경
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			int result = 0;
			if(odd > even) { //1이 많을 경우
				result = odd * 2 - 1;
				
			} else if(even > odd) { //2가 많을 경우 
				result = even * 2;
				
			} else { //1과 2의 숫자가 같을 경우
				result = odd + even;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
>>>>>>> Stashed changes
