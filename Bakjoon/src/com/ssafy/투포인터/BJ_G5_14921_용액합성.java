package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_14921_용액합성 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int number[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int start=0, end=N-1;
		
		int sum=number[start]+number[end];
		int min=Integer.MAX_VALUE;
		
		while(start!=end) {
			
			if(number[0]>=0) {
				min=number[0]+number[1];
				break;
			}
			
			if(number[N-1]<=0) {
				min=number[N-1]+number[N-2];
				break;
			}
			
			if(Math.abs(sum)<Math.abs(min)) {
				min=sum;
			}
			
			if(sum==0) {
				min=sum;
				break;
			}
			
			else if(sum<0) {
				sum-=number[start];
				start++;
			}
			else {
				sum-=number[end];
				end--;
			}
			
			sum = number[start]+number[end];
			
			
		}
		
		System.out.println(min);

	}

}
