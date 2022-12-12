package com.ssafy.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] memo = new int[10002];
		
		memo[1] = arr[1];
		if(N>=2) {
		memo[2] = arr[1]+arr[2];
		}
		for(int i=3;i<=N;i++) {
			memo[i] = Math.max(memo[i-1], Math.max(memo[i-2] + arr[i], memo[i-3]+arr[i-1]+arr[i]));
		}
		
		System.out.println(memo[N]);
	}

}
