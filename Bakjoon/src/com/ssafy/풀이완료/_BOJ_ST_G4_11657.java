package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _BOJ_ST_G4_11657 {
	
	static class line{
		int from;
		int to;
		int cost;
		
		public line(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		
		
		
	}
	
	static int N,M;
	static long[] ans;
	static line[] L;
	static boolean minusCycle;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		L = new line[M+1];
		ans = new long[N+1];
		
		for(int i=0;i<=N;i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			L[i] = new line(a,b,c);
		}
				
		bellman();
		
		
		
		if(minusCycle) System.out.println(-1);
		else {
			for(int i=2;i<=N;i++) {
				if(ans[i]==Integer.MAX_VALUE) System.out.println(-1);
				else System.out.println(ans[i]);
			}
		}

	}
	
	static void bellman() {
		ans[1]=0;
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<M;j++) {
				line l = L[j];
					if(ans[l.from] + l.cost < ans[l.to] && ans[l.from]!=Integer.MAX_VALUE) {
						ans[l.to] = ans[l.from]+l.cost;    //벨만 포드로 다 최소값 만들어줌
					}
				
			}
		}
		
		
		for(int i=0;i<M;i++) {
			line l = L[i];
				if(ans[l.from] + l.cost < ans[l.to] && ans[l.from]!=Integer.MAX_VALUE) {  //다 최소값을 만들었는데도 자꾸 기존보다 작아진다면 음수사이클 
					minusCycle = true;
				}
			
		}
		
	}

}
