package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		char[] A = br.readLine().toCharArray();
		
		char[] B = br.readLine().toCharArray();
		
		int N = A.length+1;
		int M = B.length+1;
		
		int[][] memo =  new int[N][M];
		
//		  A C A Y K P
//		C 0 1 1 1 1 1
//		A 1 1 2 2 2 2
//		P 1 1 2 2 2 3
//		C 1 2 2 2 2 3
//		A 1 2 3 3 3 3
//		K 1 2 3 3 4 4
		
		for(int r=1;r<N;r++) {
			for(int c=1;c<M;c++) {
				
				if(A[r-1]==B[c-1]) {
					memo[r][c] = memo[r-1][c-1] +1;
				}
				
				else {
					int max = Math.max(memo[r][c-1], memo[r-1][c]);
					memo[r][c] = max;
				}
			}
		}
		
		System.out.println(memo[N-1][M-1]);

	}

}
