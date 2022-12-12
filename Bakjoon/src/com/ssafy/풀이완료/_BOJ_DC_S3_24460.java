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

public class _BOJ_DC_S3_24460 {
	
	static int N,map[][];
	//static ArrayList<Integer> arl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		//arl  = new ArrayList<>();
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int answer =	pow(0,0,N);
		
		
		System.out.println(answer);
						
	}
	
	static int pow(int r,int c,int size) {
		if(size==1) {			
			return map[r][c];
		}
		
		size/=2;
		
		int arr[] = new int[4];
		
		arr[0]=(pow(r,c,size));
		arr[1]=(pow(r,c+size,size));
		arr[2]=(pow(r+size,c,size));
		arr[3]=(pow(r+size,c+size,size));
		
		Arrays.sort(arr);
		
		return arr[1];
		
		
		
		
	}

}
