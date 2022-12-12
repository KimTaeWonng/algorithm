package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1463_1로만들기 {
	
	static int N,Min,memo[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Min = Integer.MAX_VALUE;
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		memo[0]=memo[1]=0;
		
		System.out.println(dp(N));
	}
	
	public static int dp(int n) {
		
		if(memo[n]==-1) {
			if(n%6==0) {   //6의 배수도 해줘야댐
				memo[n] = Math.min(Math.min(dp(n/3), dp(n/2)), dp(n-1))+1;
			}
			else if(n%3==0) {
				memo[n] = Math.min(dp(n/3), dp(n-1))+1;  //3으로 나누거나 1 빼주거나
			}else if(n%2==0) {
				memo[n] = Math.min(dp(n/2), dp(n-1))+1;  //2로 나누거나 1빼주거나
			}else {
				memo[n] = dp(n-1)+1;
			}
		}
		
		
		return memo[n];
		
	}

}
