package com.ssafy.소수만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 소수만드는법 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int i=N;i<=M;i++) {
			
			if(isPrime(i)) {
				bw.write(i+"\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static boolean isPrime(int num) {
		if(num==1) {
			return false;
		}
		if(num==2) {
			return true;
		}
		
		if(num%2==0) {
			return false;
		}
		
		
		for(int i=3;i<=Math.sqrt(num);i+=2) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}

}
