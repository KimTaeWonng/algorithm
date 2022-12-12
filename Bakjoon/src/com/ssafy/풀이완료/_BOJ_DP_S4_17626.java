package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S4_17626 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[] memo = new int[50001];
		
		int N = Integer.parseInt(br.readLine());
		
		
		//1 2 3  1 2 3 4 2  1 2 3 4 2 3 4  1 2 3 4 2 3 4 4
		//1      4          9              16  제곱수일때 1됨
		
		memo[1]=1;
		memo[2]=2;
		for(int i=2;i<=N;i++) {
			int min=5;
			
			for(int j=1;j<=Math.sqrt(i);j++) {
				min = Math.min(min, memo[i-j*j]);
				
			}	
			memo[i] = min +1 ;
		}
		
		System.out.println(memo[N]);

	}

}
