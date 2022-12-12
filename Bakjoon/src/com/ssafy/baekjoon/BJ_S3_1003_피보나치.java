package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_1003_피보나치 {
	
	static class pibo{
		int zero;
		int one;
		
		public pibo(int zero, int one) {
			super();
			this.zero = zero;
			this.one = one;
		}
		
		
	}
	
	static int N;
	static pibo[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		p = new pibo[41];
		for(int i=0;i<N;i++) {
			
			int A = Integer.parseInt(br.readLine());
			p[0] = new pibo(1,0);
			p[1] = new pibo(0,1);
			
			fibonacci(A);
			System.out.println(p[A].zero+" "+p[A].one);
		}

	}
	
	static pibo fibonacci(int n) {
						
		if(p[n]==null) {
			p[n] = new pibo(fibonacci(n-1).zero+fibonacci(n-2).zero, fibonacci(n-1).one+fibonacci(n-2).one);
		}
		
		return p[n];
	}

}
