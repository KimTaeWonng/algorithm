package com.ssafy.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_15657_N과M8 {
	
	static int[] number, answer;
	static int N,M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		answer = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(number);
		
		comb(0,0);
		
		System.out.println(sb);

	}

	private static void comb(int start, int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				sb.append(answer[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			answer[cnt] = number[i];
			comb(i,cnt+1);
		}
		
	}

}
