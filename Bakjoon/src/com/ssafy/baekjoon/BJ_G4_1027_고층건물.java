package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class BJ_G4_1027_고층건물 {
	
	//각각의 건물에서 왼쪽,오른쪽으로 뻗어나가 각 건물들의 높이를 비교한다.
	//크면 그 큰 건물을 기준으로 삼고 비교해보며, 만약 나보다 클경우에는 거기까지만 본다 
	//하나의 경우에서 양옆을 모두 봤으면 그값을 MAX값과 비교한다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		
		int[] height = new int[N];
		
		
		
		st= new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		
		for(int i=0;i<N;i++) {
			int left =1; //왼쪽으로 보이는 빌딩 개수
			int right=1; //오른쪽
			int cnt=0;
			double maxLeft=0;
			double maxRight=0;
			System.out.println("i : "+i);
			
			for(int j=0;j<N;j++) {
				if(i-left<0) { //더이상 왼쪽에 건물이 없으면
					break;
				}else {
					double temp = Math.sqrt(Math.pow(Math.abs(height[i]-height[i-left]),2)+Math.pow(left, 2));
					if(temp<=maxLeft) {
						left++;
						continue;					
					}				
					maxLeft= Math.max(maxLeft,temp);
					System.out.print(maxLeft+" ");
					cnt++;
					left++;
				}
			}
			System.out.print(" <-left right-> ");
			
			for(int j=0;j<N;j++) {
				if(i+right>=N) { //더이상 오른쪽에 건물이 없으면
					break;
				}else {
					double temp = Math.sqrt(Math.pow(Math.abs(height[i]-height[i+right]),2)+Math.pow(right, 2));
					if(temp<=maxRight) {
						right++;
						continue;					
					}
					maxRight= Math.max(maxRight,temp);
					System.out.print(maxRight+" ");
					cnt++;
					right++;
				}
			}
			System.out.println();
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);

	}

}
