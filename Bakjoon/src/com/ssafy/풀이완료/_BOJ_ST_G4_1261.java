package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_ST_G4_1261 {
	
	static class point{
		int r,c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}

	static int N,M,map[][],min;
	static int deltas[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int memo[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map  = new int[N][M];
		memo = new int[N][M];

		for(int r=0;r<N;r++) {
			String str[] = br.readLine().split("");
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
			memo[r][c] = Integer.MAX_VALUE;
			}
		}
		
		min = Integer.MAX_VALUE;
		
		memo[0][0] = 0;
		
		bfs(0,0);
		
		System.out.println(min);

	}
	
	static void bfs(int r,int c) {
		
		Queue<point> p = new LinkedList<>();
		p.offer(new point(r,c));
		
		while(!p.isEmpty()) {
			point temp = p.poll();
			
			if(temp.r==N-1 && temp.c==M-1) {
				min = Math.min(min, memo[temp.r][temp.c]);
			}
			
			if(min<=memo[temp.r][temp.c]) continue;
			
			for(int d=0;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if(isin(nr,nc)) {
					if(memo[nr][nc] > memo[temp.r][temp.c] + map[nr][nc]) {
						memo[nr][nc] = memo[temp.r][temp.c] + map[nr][nc];
						
						
						
						p.offer(new point(nr,nc));
						
					}
				}
			}
			
		}
		
	}
	
	static boolean isin(int r,int c) {
		return (r>=0 && r<N && c>=0 && c<M);
	}

}
