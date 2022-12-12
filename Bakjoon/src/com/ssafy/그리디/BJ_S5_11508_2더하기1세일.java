package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S5_11508_2더하기1세일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Long[] arr = new Long[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		long ans = 0;
		for(int i=0;i<N;i++) {
			if((i+1)%3==0) {
				continue;
			}
			
			ans += arr[i];
		}
		
		System.out.println(ans);

	}

}
