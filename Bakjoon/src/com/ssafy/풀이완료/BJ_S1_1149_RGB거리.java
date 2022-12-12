package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_1149_RGB거리 {
	
	static int N,memo[][],color[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		memo = new int[N][3];
		color = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			color[i][0]=r;
			color[i][1]=g;
			color[i][2]=b;
		}
		
		memo[0][0]=color[0][0];
		memo[0][1]=color[0][1];
		memo[0][2]=color[0][2];
		
		int a = dp(N-1,0);
		int b = dp(N-1,1);
		int c = dp(N-1,2);
		
		System.out.println(Math.min(a, Math.min(b, c)));
	

	}
	
	static int dp(int n,int c) {
		
		if(memo[n][c]==0) {
			if(c==0) {
				memo[n][c] = Math.min(dp(n-1,1), dp(n-1,2))+color[n][c];
			}else if(c==1) {
				memo[n][c] = Math.min(dp(n-1,0), dp(n-1,2))+color[n][c];
			}else {
				memo[n][c] = Math.min(dp(n-1,0), dp(n-1,1))+color[n][c];
			}
		}
		
		return memo[n][c];
	}

}
