package com.ssafy.풀이완료;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S1_16456 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long[] memo = new long[100002];
		
		int N = Integer.parseInt(br.readLine());
		
		memo[1]=1; //1,1,2,3,4,6
		memo[2]=1;
		memo[3]=2;
		
		for(int i=4;i<100002;i++) {
			memo[i] = (memo[i-1]+memo[i-3])%100000007;
		}
		
		System.out.println(memo[N]);
		

	}

}
