package com.ssafy.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_2635_수이어가기 {
	static int max,N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N =Integer.parseInt(br.readLine());
		
		for(int i=N;i>0;i--) {
			StringBuilder temp = new StringBuilder();
			temp.append(N+" ");
			int cnt=1;
			int prev = N;
			brute(i,temp,cnt,prev);
			
			
		}
		
		System.out.println(max);
		System.out.println(sb);
		
		

	}

	private static void brute(int n, StringBuilder temp,int cnt,int prev) {
		if(n<0) {
			if(cnt>max) {
				max = cnt;
				sb = temp;
			}
			return;
		}
		

		temp.append(n+" ");
		
		brute(prev-n,temp,cnt+1,n);
		
		
		
	}

}
