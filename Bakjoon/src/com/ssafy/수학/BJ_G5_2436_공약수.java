package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_2436_공약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		long gcd = Integer.parseInt(st.nextToken());
		long lcm = Integer.parseInt(st.nextToken());
		
		long temp = gcd*lcm;    //gcd * lcm  = 두 수의 곱
		
		long min = Integer.MAX_VALUE;
		long a = gcd;
		long b = temp/a;
		
		long ans1 =0;
		long ans2 =0;
		while(a<=b){
			
			
			if(gcd(a,b)==gcd && a*b/gcd==lcm) {
				if(min>a+b) {
					min = a+b;
					ans1 = a;
					ans2 = b;
				}
			}
			
			a +=gcd;
			b = temp/a;
			
			
		}
		
		System.out.println(ans1 +" "+ans2);

	}
	
	static long gcd(long a,long b) {
		if(a>b) {
			if(a%b==0) {
				return b;
			}else {
				return gcd(b, a%b);
			}
		}else {
			if(b%a==0) {
				return a;
			}else {
				return gcd(a, b%a);
			}
		}
	}

}
