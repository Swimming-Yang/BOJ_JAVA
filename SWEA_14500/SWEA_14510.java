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



