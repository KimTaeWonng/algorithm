package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_14002_가장긴증가수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] LIS = new int[N];
		ArrayDeque<Integer>[] arl = new ArrayDeque[N];
		
		for(int i=0;i<N;i++) {
			arl[i] = new ArrayDeque<>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max =0;
		int cnt =0;
		ArrayDeque<Integer> maxArl = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			LIS[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					LIS[i] = Math.max(LIS[i], LIS[j]+1);
				}
			}	
				max = Math.max(LIS[i], max);
			
		}	
		
		for(int i=N-1;i>=0;i--) {
			
			if(LIS[i]==max) {
				maxArl.addFirst(arr[i]);
			}
			
		}
		
		
		System.out.println(max);
		

	}

}
