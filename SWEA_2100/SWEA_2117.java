package SWEA_2100;

import java.io.*;
import java.util.*;

public class SWEA_2117 {
    
    public static int[][] map;
    public static ArrayList<Home> info;
    public static int maxHomes = 0;
    
    public static class Home {
        int row;
        int col;
        
        public Home(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testcase_num = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= testcase_num; t++) {
            st = new StringTokenizer(br.readLine());
            int Size = Integer.parseInt(st.nextToken());
            int Pay = Integer.parseInt(st.nextToken());
            
            map = new int[Size][Size];
            info = new ArrayList<>();
            maxHomes = 0;
            
            // 맵 입력 및 집 위치 저장
            for(int row = 0; row < Size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < Size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    if(map[row][col] == 1) {
                        info.add(new Home(row, col));
                    }
                }
            }
        
            for(int k = 1; k <= Size + 1; k++) {
                
                int operatingCost = k * k + (k-1) * (k-1);
                if(operatingCost > info.size() * Pay) break;
                
                //*2. 맵의 모든 위치에서 중심점으로 탐색
                for(int centerRow = 0; centerRow < Size; centerRow++) {
                    for(int centerCol = 0; centerCol < Size; centerCol++) {
                        
                        int serviceHomes = 0;
                        
                        //*3. info에 저장된 모든 집과의 맨해튼 거리 계산
                        for(Home home : info) {
                            int distance = Math.abs(home.row - centerRow) + Math.abs(home.col - centerCol);
                            
                            //*4. 거리가 K-1 이하이면 서비스 범위 내
                            if(distance < k) {
                                serviceHomes++;
                            }
                        }
                        
                        //* 5. 수익 계산 및 최대값 갱신
                        int profit = serviceHomes * Pay - operatingCost;
                        if(profit >= 0 && serviceHomes > maxHomes) {
                            maxHomes = serviceHomes;
                        }
                    }
                }
            }
            
            System.out.println("#" + t + " " + maxHomes);
        }
    }
}