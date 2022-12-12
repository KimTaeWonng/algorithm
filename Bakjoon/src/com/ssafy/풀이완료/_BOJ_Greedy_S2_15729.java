package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_Greedy_S2_15729 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i=0;
		int cnt=0;
		while(i<arr.length) {
			if(arr[i]==1) {
				cnt++;
				arr[i]=0;
				if(i<arr.length-2) {
					//내 앞의 2개가 존재하면 그 2개의 숫자를 바꿔준다.
					if(arr[i+1]==1) {
						arr[i+1]=0;
					}else {
						arr[i+1]=1;
					}
					
					if(arr[i+2]==1) {
						arr[i+2]=0;
					}else {
						arr[i+2]=1;
					}
					
				}else if(i<arr.length-1) {
					//내 앞에 1개만 존재하면 그 2개의 숫자를 바꿔준다.
					if(arr[i+1]==1) {
						arr[i+1]=0;
					}else {
						arr[i+1]=1;
					}
				}
				
			}
			
			i++;				
		}
		
		System.out.println(cnt);

	}

}
