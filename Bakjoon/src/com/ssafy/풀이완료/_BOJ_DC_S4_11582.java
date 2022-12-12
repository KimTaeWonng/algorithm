package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_DC_S4_11582 {
	static int N,arr[],M;

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
		
		M = Integer.parseInt(br.readLine());
		
		pow(0,arr,0);
		
		for(int i=0;i<N;i++) {
			bw.write(arr[i]+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	static void pow(int n,int[] arr,int size) {
		
		
		size = arr.length/M;
		
		
		for(int i=0;i<M;i++) {
			Arrays.sort(arr,n,n+size);
			n+=size;
		}
				
	}

}
