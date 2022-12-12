package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G2_2749_피보나치3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int pisano = 1500000; // 피보나치를 N으로 나머지 연산할 때, 피사노 주기 15x10^(N-1)마다 같은 값을 가진다 1000000= 10^6
		
		long N = Long.parseLong(br.readLine());
		
		long[] pibo = new long[pisano];
		
		pibo[0]=0;
		pibo[1]=1;
		pibo[2]=1;
		
		if(N>pisano) {
			N%=pisano;
		}
		
		for(int i=3;i<=N;i++) {			
			pibo[i] = (pibo[i-2]+pibo[i-1]) %1000000;
		}
		//System.out.println(Arrays.toString(pibo));
		System.out.println(pibo[(int)N]);

	}

}
