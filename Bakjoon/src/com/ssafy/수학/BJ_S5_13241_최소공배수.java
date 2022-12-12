package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_13241_최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long K = gcd(N,M);
		
		System.out.println(N*M/K);
		

	}
	
	static long gcd(long a, long b) {
		if(a>=b) {
			if(a%b==0) {
				return b;
			}else {
				return gcd(b,a%b);
			}
		}else {
			if(b%a==0) {
				return a;
			}else {
				return gcd(a,b%a);
			}
		}
	}

}
