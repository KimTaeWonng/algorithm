package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_17025_IcyPerimeter {
	
	static class point{
		int r;
		int c;
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static char[][] map;
	static int N,width,perimeter,cnt,check[][],deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N =Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visited = new boolean[N][N];
		check = new int[N][N];
		
		for(int r=0;r<N;r++) {
			String[] temp = br.readLine().split("");
			for(int c=0;c<N;c++) {
				map[r][c] = temp[c].charAt(0);
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]=='#' && !visited[r][c]) {
					cnt++;
					bfs(r,c);
				}
			}
		}
		
		visited = new boolean[N][N];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(check[r][c]!=0 && !visited[r][c]) {
					bfs2(r,c);
				}
			}
			
		}
		
		System.out.println(width+" "+perimeter);
		
		

	}

	private static void bfs2(int r, int c) {
		visited[r][c] = true;
		Queue<point> q = new LinkedList<>();
		q.add(new point(r,c));
		int w = 0;
		int p = 0;
		while(!q.isEmpty()) {
			
			point temp = q.poll();
			w++;
			int peri = 4;
			for(int d=0;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if(isin(nr,nc) && check[temp.r][temp.c]==check[nr][nc]) {
					peri--;
				}
			}
			p +=peri;
			
			for(int d=0;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if(isin(nr,nc) && map[nr][nc]=='#' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new point(nr,nc));
				}
			}
		}
		
		if(w>=width) {
			if(w==width) {
				perimeter = Math.min(perimeter, p);
			}else {
				width = w;
				perimeter = p;
			}
		}
		
	}

	private static void bfs(int r, int c) {
		
		visited[r][c] = true;
		check[r][c] = cnt;
		Queue<point> q = new LinkedList<>();
		q.add(new point(r,c));
		
		while(!q.isEmpty()) {
			
			point temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if(isin(nr,nc) && map[nr][nc]=='#' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					check[nr][nc] = cnt;
					q.add(new point(nr,nc));
				}
			}
		}
		
	}
	
	static boolean isin(int r,int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
