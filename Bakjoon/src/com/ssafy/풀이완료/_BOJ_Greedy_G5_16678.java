package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_Greedy_G5_16678 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long cnt=0;
		long top=1;
		for(int i=1;i<=N;i++) {
			long hacker=0;
			if(arr[i]>top) {
				hacker= arr[i]-top;
				arr[i] = arr[i]-hacker;
				
			}
			top = arr[i]+1;
			cnt+=hacker;
			
		}
		
		System.out.println(cnt);

	}

}
