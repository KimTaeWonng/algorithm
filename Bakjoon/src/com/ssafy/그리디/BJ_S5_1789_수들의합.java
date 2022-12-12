package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_1789_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long S = Long.parseLong(br.readLine());
		
		long sum = 0;
		long cnt = 0;
		while(sum<S) {
			
			cnt++;
			
			sum+=cnt;
			
			
		}
		
		if(sum>S) {
		System.out.println(cnt-1);
		}else {
			System.out.println(cnt);
		}
	}

}
