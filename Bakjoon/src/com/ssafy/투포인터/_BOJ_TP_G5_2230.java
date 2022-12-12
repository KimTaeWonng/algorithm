package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_TP_G5_2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int number[] = new int[N];
		
		for(int i=0;i<N;i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(number);
		
		int start = 0;
		int end=0;
		int num=0;
		int max=Integer.MAX_VALUE;
		while(end<N && start<N) {
			
				
			num = number[end]-number[start];
			
			if(num<M) {
				end++;
			}
			else {
				max=Math.min(max, num);
				start++;
			}
			
			
			
			
		}
		
		System.out.println(max);

	}

}
