package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_1182 {
	
	//부분집합
	
	static int N,S,input[];
	static int Goal, cnt;
	//static int stt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		recur(0,0);
		if(S==0) cnt-=1;
		bw.write((cnt)+"\n");
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	public static void recur(int a, int Goal) {
		if(a==N) {
			if(Goal==S) {			 
				cnt++;									
		}
			return;
		}
		
		recur(a+1,Goal + input[a]);
		recur(a+1,Goal);
		
	}

}
