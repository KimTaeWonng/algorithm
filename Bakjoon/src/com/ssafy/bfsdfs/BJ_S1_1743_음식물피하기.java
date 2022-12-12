package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1743_음식물피하기 {
	
	static class point{
		int r;
		int c;
		
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int N,M, map[][],max, deltas[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			map[r][c] = 1;
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					bfs(r,c);
				}
			}
		}
		
		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		Queue<point> p = new LinkedList<>();
		p.add(new point(r,c));
		visited[r][c] = true;
		int cnt=1;
		
		while(!p.isEmpty()) {
			point temp = p.poll();
			
			for(int d=0;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isin(nr,nc) && map[nr][nc]==1 && !visited[nr][nc]) {
					p.add(new point(nr,nc));
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
		
	}
	
	static boolean isin(int r,int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
