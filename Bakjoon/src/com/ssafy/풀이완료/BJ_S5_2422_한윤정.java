package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_2422_한윤정 {
	static int N,M,ice[],no[][],answer;
	static int choice[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ice = new int[N];
		no 	= new int[N+1][N+1];
		for(int i=0;i<N;i++) {
			ice[i] = i+1;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			no[a][b] = 1;
		}
		
		choice = new int[3];
		
		comb(0,0);
		
		System.out.println(answer);

	}
	
	static void comb(int cnt,int start) {
		if(cnt==3) {			
				if(no[choice[0]][choice[1]]==1) return;
				if(no[choice[0]][choice[2]]==1) return;
				if(no[choice[1]][choice[2]]==1) return;
				if(no[choice[1]][choice[0]]==1) return;
				if(no[choice[2]][choice[1]]==1) return;
				if(no[choice[2]][choice[0]]==1) return;
			answer++;
			return;
		}
		
		
		for(int i=start;i<N;i++) {
			choice[cnt]=ice[i];
			comb(cnt+1,i+1);
		}
	}

}
