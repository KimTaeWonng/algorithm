package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_10815_숫자카드 {
	static int N,M,sang[],target[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sang = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			sang[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		target = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sang);
		
		for(int i=0;i<M;i++) {
			bw.write(binary(target[i])+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		

	}
	
	static int binary(int a) {
		int first = 0;
		int last = N-1;
		int mid;
		
		while(first<=last) {
			mid = (first+last)/2;
			
			if(a==sang[mid]) return 1;
			else if(a>sang[mid]) first = mid+1;
			else last = mid-1;
		}
		return 0;
	}

}
