package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_2018_수들의합5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		int number[] = new int[N];
		
		for(int i=0;i<N;i++) {
			number[i] = i+1;
		}
		
		int start=0,end=0;
		int sum=0;
		while(true) {
			
			if(sum==N) {
				cnt++;
				sum-=number[start];
				start++;
				
			}
			
			else if(sum>N || end==N) {
				sum-=number[start];
				start++;
			}else if(sum<N) {
				sum+=number[end];
				end++;
			}
			
			if(start==N) {
				break;
			}
			
			//System.out.println(start+" "+end+" "+sum);
			
			
			
			
		}
		System.out.println(cnt);

	}

}
