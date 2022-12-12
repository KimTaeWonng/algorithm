package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_2961_신맛쓴맛 {
	
	static int sin[],bit[],N, S,B=1,Min=Integer.MAX_VALUE;
	static boolean isSelected[];
	static boolean allFalse;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N= Integer.parseInt(br.readLine()); //재료개수
		
		sin = new int[N];
		bit = new int[N];
		isSelected = new boolean[N];
		
		for(int n=0;n<N;n++) {
			st =new StringTokenizer(br.readLine());
			sin[n]=Integer.parseInt(st.nextToken());
			bit[n]=Integer.parseInt(st.nextToken());     //재료 맛 입력
		}
		
		subset(0);
		
		System.out.println(Min);

	}
	
	static void subset(int cnt) {
		if(cnt==N) {
			S=1;B=0;
			allFalse = true;
			
			for(int i=0;i<N;i++) {
				if(isSelected[i])
					allFalse=false;
			}
			if(allFalse) {             //재료 무조건 하나사용
				return;
			}
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					S*=sin[i];
					//System.out.println(S);
					B+=bit[i];
					//System.out.println(B);
				}
			}
			
			Min = Math.min(Min, Math.abs(S-B));
			
			
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}

}
