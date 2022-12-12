package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class BJ_S5_1969_DNA {
	static int N,M,Min;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String[] str = new String[N];
		
		for(int i=0;i<N;i++) {
			str[i]=br.readLine();
		}
		
		String[] input = {"T","A","C","G"};
		
		int distance=0;
		
		for(int i=0;i<M;i++) {
			int[] check = new int[4];
			for(int j=0;j<N;j++) {
				switch(str[j].charAt(i)) {
				case 'T':
					check[0]++;
					break;
				case 'A':
					check[1]++;
					break;
				case 'C':
					check[2]++;
					break;
				case 'G':
					check[3]++;
					break;
				}
			}
			int Max=0;
			for(int j=0;j<4;j++) {
				if(Max<=check[j]) {
					Max=check[j];
				}
			}
			distance += N-Max;
			
			sb.append(checkTACG(input,check,Max));
		}
		
		System.out.println(sb);
		System.out.println(distance);
		

	}
	
	static String checkTACG(String[] a, int[] b,int max) {   //TACG 근데 사전순
		if(max == b[1]) return a[1];
		else if(max == b[2]) return a[2];
		else if(max == b[3]) return a[3];
		else return a[0];
	}
	
	

}
