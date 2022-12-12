package com.ssafy.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_S3_15656_N과M7 {
	
	static int N,M,number[],answer[];
	static boolean check[];
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
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(number);
		
		
		
		backtracking(0,0);
		
		System.out.println(sb);
		
	}

	private static void backtracking(int n, int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				sb.append(answer[i]+" ");;
			}
			sb.append("\n");
			return;
		}
		
		
		
		for(int i=0;i<N;i++) {
			if(check[i]) continue;
			answer[cnt] = number[i];
			check[i]= true;
			backtracking(i, cnt+1);
			check[i]= false;
		}
		
	}

}
