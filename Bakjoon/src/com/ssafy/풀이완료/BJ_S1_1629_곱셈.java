package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_S1_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
			
		bw.write(exp(A,B,C)+"\n");
		bw.flush();
		bw.close();
		br.close();
	

	}
	
	static long exp(long a,long b,long c) {
		if(b==0) {
			return 1%c;
		}
		if(b==1) {
			return a%c;
		}
		
		long l = exp(a,b/2,c);
		
		if(b%2==0) {
			return (l*l)%c ;
		}else {
			return (l*l%c)*a%c;
		}
		
		
	}

}
