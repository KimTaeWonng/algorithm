package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스 {
	
	static class point{
		int r,c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
				
	}
	
	static int N,M,D ,map[][],sum,max,mon;
	
		

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) {
					mon++;
				}
			}
		}
		
		

	}
	
	static void archor(int cnt) {
		
		if(cnt==3) {
			attack();
			
			return;
		}
				
			for(int c=0;c<M;c++) {
				map[N][c] = 2;
				archor(cnt+1);
				map[N][c] = 0;
			}		
	}
	
	static void attack() {
		sum = mon;
		Queue<point> A = new LinkedList<>();  //몬스터들
		Queue<point> D = new LinkedList<>();  //궁수들
		
		for(int c=0;c<M;c++) {
			if(map[N][c]==2) {
				A.offer(new point(N,c));
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==1) {
					D.offer(new point(r,c));
				}
			}
		}
		
		int[][] map2 = new int[N+1][M];
		
		for(int r=0;r<=N;r++) {
			for(int c=0;c<M;c++) {
				map2[r][c] = map[r][c];   //맵복사
			}
		}
		
		for(int i=1;i<=N;i++) {
			boolean[][] check = new boolean[N+1][M+1];
		}
		
	}
	
	static void 

}
