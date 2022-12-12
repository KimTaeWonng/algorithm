package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_15649_N과M시리즈 {
	
	static int N,M,input[],number[];
	static boolean visit[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		visit = new boolean[N];
		number = new int[M];
		
		for(int i=0;i<N;i++) {
			input[i]=i+1;
		}
		
		dupliComb(0,0);
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void perm(int cnt) throws IOException {   //순열
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				bw.write(number[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			
			number[cnt] = input[i];
			visit[i] = true;
			perm(cnt+1);
			visit[i] = false;
		}
	}
	
	static void comb(int cnt, int start) throws IOException {  //조합
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				bw.write(number[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			number[cnt] = input[i];
			comb(cnt+1,i+1);
		}
	}
	
	static void dupliPerm(int cnt) throws IOException {  //중복 순열
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				bw.write(number[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			number[cnt] = input[i];
			
			dupliPerm(cnt+1);
		}
	}
	
	static void dupliComb(int cnt,int start) throws IOException { //중복 조합
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				bw.write(number[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			number[cnt] = input[i];
			
			dupliComb(cnt+1,i);
		}
	}

}
