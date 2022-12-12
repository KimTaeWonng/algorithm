package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1497_기타콘서트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static String[] yns;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		yns= new String[M];
		boolean[] visit = new boolean[N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			st.nextToken(); //기타의 이름부분 (버리는부분임)
			yns[i]=st.nextToken();
		}

	}
	
	private static void subSetByRecur(int cnt, boolean[] isvisit) {
		if(cnt==N) {
			System.out.println(Arrays.toString(isvisit));
			return;
		}
		
		isvisit[cnt]=true;
		subSetByRecur(cnt+1, isvisit);
		isvisit[cnt]=false;
		subSetByRecur(cnt+1, isvisit);
	}

}
