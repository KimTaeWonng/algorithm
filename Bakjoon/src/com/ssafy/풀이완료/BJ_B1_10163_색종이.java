package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int M=1001;
		int[][] map = new int[M][M];
		
		int N= Integer.parseInt(br.readLine());
		int[] answer= new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int rt = Integer.parseInt(st.nextToken());
			int ct = Integer.parseInt(st.nextToken());
			
			for(int r=0;r<rt;r++) {
				for(int c=0;c<ct;c++) {
					map[R+r][C+c] = i;
				}
			}
			
			
			
		}
		
		for(int r=0;r<M;r++) {
			for(int c=0;c<M;c++) {
				answer[map[r][c]]++;
			}
		}
		
		for(int i=1;i<N+1;i++) {
			bw.write(answer[i]);
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
