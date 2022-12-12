package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_25344_행성정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N-2];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N-2;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-3;i++) {
			long temp = gcd(arr[i],arr[i+1]);
			
			arr[i+1] = arr[i]*arr[i+1]/temp;
		}
		
		System.out.println(arr[N-3]);

	}
	
	static long gcd(long a,long b) {
		if(a>b) {
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
