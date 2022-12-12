package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S3_9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] memo = new int[12];
		
		memo[1]= 1;
		memo[2]= 2;
		memo[3]= 4;
		
		for(int i=4;i<12;i++) {
			memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
		}
		
		
		for(int t=0;t<T;t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			bw.write(memo[N]+"\n");
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
