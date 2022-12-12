package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_Greedy_S2_16112 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] quest = new long[N];
		long sum =0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			quest[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(quest);
		
		for(int i=0;i<N;i++) {
						
			if(i<K) {
				sum += (quest[i]*i);
			}else {
				sum += (quest[i]*K);
			}
			//System.out.println(sum);
		}
		
		System.out.println(sum);
	}

}
