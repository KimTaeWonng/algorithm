package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S1_10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long memo[][] = new long[101][9];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<9;i++) {  //1,2,3,4,5,6,7,8,9
			memo[1][i]=1;
		}
		
		for(int i=0;i<9;i++) {
			if(i==8)
			memo[2][i]=1;
			else 
			memo[2][i]=2;
		}
		
		for(int i=3;i<101;i++) {
			for(int j=0;j<9;j++) {
				if(j==0) {
					memo[i][j] = memo[i-2][j]+memo[i-1][j+1]%1000000000;
				}else if(j==8) {
					memo[i][j] = memo[i-1][j-1]%1000000000;
				}else {
					memo[i][j] = memo[i-1][j-1]+memo[i-1][j+1]%1000000000;
				}
			}
		}
		
		long answer=0;
		
		for(int i=0;i<9;i++) {
			answer+= memo[N][i];
		}
		
		System.out.println(answer%1000000000);
		
		

	}

}
