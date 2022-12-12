package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int money = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt=0;
		while(money!=0) {
			for(int i=N-1;i>=0;i--) {
				if(money>=coin[i]) {
					cnt++;
					money-=coin[i];
					break;
					
				}
			}
		}
		
		System.out.println(cnt);

	}

}
