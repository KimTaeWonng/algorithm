package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_TP_S3_2003 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int number[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		int end=0;
		int cnt=0;
		int sum=0;
		while(true) {
			
			if(sum==M) {
				cnt++;
				sum-=number[start];
				start++;
			}
			
			else if(sum>M || end==N) {
				sum-=number[start];
				start++;
			}else if(sum<M) {
				sum+=number[end];
				end++;
			}
			
			
			if(start==N) {
				break;
			}
		}
		
		System.out.println(cnt);

	}

}
