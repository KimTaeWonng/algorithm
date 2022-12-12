package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_20300_서강근육맨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long[] min;
	
		long ans = 0;
		
		if(N%2==0) {
			min = new long[N/2];
			for(int i=0;i<min.length;i++) {
				min[i] = arr[i]+arr[N-i-1];
				ans = Math.max(ans, min[i]);
			}
		}else {
			min = new long[N/2+1];
			for(int i=0;i<min.length;i++) {
				min[i] = arr[i]+arr[N-i-2];
				if(i==min.length-1) min[i] = arr[i];
				ans = Math.max(ans, min[i]);
			}
		}
		
		System.out.println(ans);

	}

}
