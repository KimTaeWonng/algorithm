package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_S4_1676_팩토리얼 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		BigInteger b1 = new BigInteger("1");
		BigInteger b2 = new BigInteger("1");
		BigInteger b3 = new BigInteger("1");
		int N = Integer.parseInt(br.readLine());
		//b1 = BigInteger.valueOf(1);
		for(int i=1;i<=N;i++) {
			b1= b1.multiply(b2);
			b2 =b2.add(b3);
			//System.out.println(b1);
			//System.out.println(b2);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(b1.toString());
		
		//System.out.println(sb);
		sb.reverse();
		
		int cnt=0;
		int i=0;
		while(true) {
			if(sb.charAt(i)!='0') {
				break;
			}else {
				cnt++;
			}
			i++;
		}
		
		System.out.println(cnt);
		

	}

}
