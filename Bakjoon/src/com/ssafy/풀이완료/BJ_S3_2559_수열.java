package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] temper = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			temper[i]= Integer.parseInt(st.nextToken());
		}
		
		int Max = Integer.MIN_VALUE;
		
		for(int i=0;i<=N-K;i++) {
			int temp=0;
			int k=0;
			while(true) {
				if(k==K) break;
				temp+=temper[i+k];
				k++;
			}
			Max = Math.max(Max, temp);
					
		}
		
		bw.write(Max+"\n");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
