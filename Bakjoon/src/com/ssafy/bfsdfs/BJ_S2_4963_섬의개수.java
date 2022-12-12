package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_4963_섬의개수 {
	
	static class point{
		int r;
		int c;
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int N,M,map[][], deltas[][]= {{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			cnt=0;
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N==0 && M==0) {
				break;
			}
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<M;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(map[r][c]==1 && !visited[r][c]) {
						cnt++;
						bfs(r,c);
					}
				}
			}
			
			bw.write(cnt+"\n");
		}
		
		bw.flush();

	}

	private static void bfs(int r, int c) {
		Queue<point> q = new LinkedList<>();
		
		q.add(new point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			
			for(int d=0;d<8;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isin(nr,nc) && map[nr][nc]==1 && !visited[nr][nc]) {
					q.add(new point(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
		
		
	}
	
	static boolean isin(int r, int c) {
		return r<N && r>=0 && c<M && c>=0;
	}

}
