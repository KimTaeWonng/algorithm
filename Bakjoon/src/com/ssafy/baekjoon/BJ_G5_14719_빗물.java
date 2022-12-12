package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_14719_빗물 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] height = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int water = 0;
		
		for(int i=0;i<W;i++) {
			if(i==0 || i==W-1) continue;
			int L=height[i],R=height[i];  //일단 나로 설정해둠
			
			for(int j=0;j<i;j++) {
				L = Math.max(L, height[j]);  //내 왼쪽에 가장 큰 기둥
			}
			
			for(int j=i+1;j<W;j++) {
				R = Math.max(R, height[j]);  //내 오른쪽 가장 큰 기둥
			}
			
			if(L!=height[i] || R!=height[i]) // 내가 젤 높은곳이 아니라면
			water+= Math.min(L, R) - height[i]; // 물 고이는 곳 = 더 낮은곳-내 높이
		}
		
		System.out.println(water);
	}

}
