package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B3_2747_피보나치 {
	static long arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		arr = new long[91];
		for(int i=0;i<91;i++) {
			arr[i]=-1;
		}
		arr[0]=0;
		arr[1]=1;
		
		fibonacci(90);
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		long answer=0;

		answer = arr[N];
		System.out.println(answer);
		

	}
	
	static long fibonacci(int n) {
		if(arr[n]!=-1) {
			return arr[n];
		}else {
			return arr[n] = fibonacci(n-1)+fibonacci(n-2);
		}
	}

}
