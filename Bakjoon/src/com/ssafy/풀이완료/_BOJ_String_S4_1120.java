package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class BJ_S4_1120_문자열 {
	
	static String X,Y;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		X = st.nextToken();
		Y = st.nextToken();
		int cnt=0;
		
		if(Y.length()==X.length()) {        //길이가 같을때
			for(int i=0;i<Y.length();i++) {
				if(Y.charAt(i)!=X.charAt(i)) {
					cnt++;
				}
			}
		}else if(Y.contains(X)) {         //완전 포함될 때
			cnt =0;
		}else {
			int MIN=Integer.MAX_VALUE;
			for(int i=0;i<=Y.length()-X.length();i++) {
				int c=0;
				for(int j=0;j<X.length();j++) {
					if(X.charAt(j)!=Y.charAt(j+i)) {
						c++;
					}
				}
				MIN = Math.min(c, MIN);
				cnt=MIN;
			}
		}
		
		System.out.println(cnt);
		
		
		
			

	}
	
	
}
