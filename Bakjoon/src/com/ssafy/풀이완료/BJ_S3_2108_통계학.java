package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S3_2108_통계학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] count = new int[8001];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			count[arr[i]+4000]++;
		}
		
		Arrays.sort(arr);
		
		//산술평균
		double sum=0;
		for(int i=0;i<N;i++) {
			sum+=arr[i];
		}
		sum = sum/N;
		if(sum>0) {
			if(sum%1>=0.5) sum=(int)sum+1;
		}else if(sum<0) {
			if(sum%1>=0.5) sum=(int)sum-1;
		}
		if(sum>-0.5 && sum<0.5) {
			sum=0;
		}
		
		System.out.printf("%.0f\n",sum);
		
		//중앙값
		System.out.println(arr[N/2]);
		
		//최빈값
		ArrayList<Integer> arl = new ArrayList<>();
		int max= -9999;
		
		for(int i=0;i<8001;i++) {
			if(max<count[i] && count[i]!=0) {
				max = count[i];				
			}
		}
		
		for(int i=0;i<8001;i++) {
			if(count[i]==max) {
				arl.add(i-4000);
			}
		}
		
		Collections.sort(arl);
		
		if(arl.size()>1) System.out.println(arl.get(1));
		else System.out.println(arl.get(0));
		
		
		//범위
		System.out.println(Math.abs(arr[0]-arr[N-1]));

	}

}
