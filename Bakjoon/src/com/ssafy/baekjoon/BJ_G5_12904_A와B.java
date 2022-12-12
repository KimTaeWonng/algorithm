package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_12904_A와B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder S = new StringBuilder();
		StringBuilder T = new StringBuilder();

		S.append(br.readLine());
		T.append(br.readLine());
		
		
		int a=0;
		
		a= ab(S.toString(),T.toString());

		if (a==0)
			System.out.println(0);
		else
			System.out.println(1);

	}
	
	static int ab(String s, String t) {
		if(s.length()==t.length()) {
			if(s.equals(t)) {
				return 1;
			}else {
				return 0;
			}
		}
		
		int a =0;
		if(t.charAt(t.length()-1)=='A') {
			a += ab(s,t.substring(0,t.length()-1));
		}
		
		if(t.charAt(0)=='B') {
			StringBuilder temp = new StringBuilder(t.substring(1));
			String str = temp.reverse().toString();
			a += ab(s,str);
		}
		
		if(a>0) {
			return 1;
		}else {
			return 0;
		}
	}
}