package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] wood = new int[N];
		
		for(int i=0;i<N;i++) {
			wood[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wood);
		
		int left=0,right=wood[N-1];

		while(left<right) {		
			int mid = (left+right)/2;			
			long target =0;
			
			for(int i=0;i<N;i++) {
				if(wood[i]>mid) {
					target+=wood[i]-mid;
				}
			}
			
			if(target<M) {
				right = mid;
			}else {
				left = mid+1;
			}		
		}
//		System.out.println(height);
//		System.out.println(target);
//		System.out.println(up+""+down);
		
		
		System.out.println(left-1);

	}

}
