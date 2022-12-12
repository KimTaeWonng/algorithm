package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_3036_링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int main = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N-1;i++) {
			int next = Integer.parseInt(st.nextToken());
			int gcd = gcd(main,next);
			System.out.println(main/gcd+"/"+next/gcd);
		}

	}

	private static int gcd(int main, int next) {
		if(main>=next) {
			if(main%next==0) {
				return next;
			}
				return gcd(next,main%next);			
		}else {
			if(next%main==0) {
				return main;
			}
				return gcd(main,next%main);
			
		}			
	}

}
