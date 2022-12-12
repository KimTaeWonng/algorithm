package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_S3_2407_조합 {
	static int n,m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());  // nCr
		m = Integer.parseInt(st.nextToken());
		
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		
		
		for(int i=n;i>n-m;i--) {  //n!/(n-r)!
			String s = String.valueOf(i);
			BigInteger S = new BigInteger(s);
			a= a.multiply(S);
		}
		
		for(int i=1;i<=m;i++) {    // r!
			String s = String.valueOf(i);
			BigInteger S = new BigInteger(s);
			b= b.multiply(S);
		}
		
		bw.write(a.divide(b)+"");
		
		bw.flush();
		bw.close();
		br.close();

	}
	

}
