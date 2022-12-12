package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_G5_9663_Queen {
	
	static int N,map[][],col[],cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		col = new int[N+1];
		cnt=0;
		
		Queen(1);
		
		System.out.println(cnt);


	}
	
	public static void Queen(int n) {
		if(check(n-1)) {
			return;
		}
		
		if(n>N) {
			cnt++;
			return;
		}
		
		for(int i=1;i<=N;i++) {
			col[n]=i;
			Queen(n+1);
		}
	}
	
	public static boolean check(int n) {
		for(int i=1;i<n;i++) {
			if(col[n]==col[i] || n-i == Math.abs(col[n]-col[i])) return true;
		}
		return false;
	}

}
