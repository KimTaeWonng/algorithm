package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S1_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] memo = new int[1025][1025];
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(r==1 && c==1) {
					memo[r][c] = map[r][c];
				}else {
					memo[r][c] = memo[r][c-1]+memo[r-1][c]+map[r][c]-memo[r-1][c-1];
				}
				
			}
		}
		
//		for(int r=1;r<=N;r++) {
//			for(int c=1;c<=N;c++) {
//				System.out.print(memo[r][c]+" ");				
//			}
//			System.out.println();
//		}
		
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			bw.write(memo[x2][y2]-memo[x2][y1-1]-memo[x1-1][y2]+memo[x1-1][y1-1]+"\n");
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
