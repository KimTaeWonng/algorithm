package com.ssafy.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_1476_날짜계산 {
	static int E,S,M,cnt=1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		brute(1,1,1);
		
		System.out.println(cnt);
	}

	private static void brute(int e, int s, int m) {
		if(e==E && s==S && m==M) {
			return;
		}
		
		
		
		e++;
		s++;
		m++;
		if(e==16) {
			e=1;
		}
		if(s==29) {
			s=1;
		}
		if(m==20) {
			m=1;
		}
		cnt++;
		brute(e,s,m);
		
		
	}

}
