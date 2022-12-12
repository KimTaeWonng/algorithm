package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_14490_백대열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String[] str = br.readLine().split(":");
		
		int a = Integer.parseInt(str[0]);
		
		int b = Integer.parseInt(str[1]);
		
		int c = gcd(a,b);
		
		System.out.println(a/c+":"+b/c);

	}

	private static int gcd(int a, int b) {
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
