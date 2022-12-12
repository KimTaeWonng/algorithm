package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B1_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N=100;
		int R=10;
		int cnt=0;
		
		int[][] map = new int[N][N];
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int rr=Integer.parseInt(st.nextToken());
			int cc=Integer.parseInt(st.nextToken());
			
			for(int r=0;r<10;r++) {
				for(int c=0;c<10;c++) {
					map[rr+r][cc+c] = 1;
				}
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==1) cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
