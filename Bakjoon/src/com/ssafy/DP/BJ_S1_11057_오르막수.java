package com.ssafy.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_11057_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
				
		
		int memo[][] = new int[1001][10];
		
		for(int i=0;i<10;i++) {
			memo[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k<10;k++) {
					memo[i][j]+= memo[i-1][k] % 10007;
				}
			}
		}
		
		int ans=0;
		for(int i=0;i<10;i++) {
			ans += memo[N][i] % 10007;
		}
		
		System.out.println(ans % 10007);
		
		

	}

}
