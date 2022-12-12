package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BJ_S3_10973_이전순열 {
	static int N,input[],number[],target[],gatcha,all[][],answer;
	static boolean visit[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		number = new int[N];
		target = new int[N];
		visit = new boolean[N];
		all = new int[100001][N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			input[i] = i;
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		if(answer==-1) {
			System.out.println(-1);
		}else {
			System.out.println(Arrays.toString(all[answer]));
		}
		
	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			all[gatcha]=number;
			if(number==target) {
				answer= gatcha-1;				
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			
			number[cnt]=i;
			visit[i]=true;
			perm(cnt+1);
			visit[i]=false;
		}
	}

}
