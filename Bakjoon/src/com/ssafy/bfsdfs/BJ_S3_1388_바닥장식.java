package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_1388_바닥장식 {
	
	static class point{
		int r;
		int c;
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int N,M,map[][],cnt,deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r=0;r<N;r++) {
			String[] str = br.readLine().split("");
			for(int c=0;c<M;c++) {
				if(str[c].equals("-")) {
					map[r][c]=1;
				}else {
					map[r][c]=0;
				}
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					cnt++;
					bfs1(r,c);
				}else if(map[r][c]==0 && !visited[r][c]){
					cnt++;
					bfs2(r,c);
				}
			}
		}
		
		System.out.println(cnt);

	}
	
	private static void bfs1(int r, int c) {  // -모양
		Queue<point> q = new LinkedList<>();
		
		q.add(new point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			
			for(int d=2;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isin(nr,nc) && !visited[nr][nc] && map[nr][nc]==1) {
					q.add(new point(nr,nc));
					visited[nr][nc]=true;
				}
			}
		}
		
	}

	private static void bfs2(int r, int c) {  // ㅣ모양
Queue<point> q = new LinkedList<>();
		
		q.add(new point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			
			for(int d=0;d<2;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isin(nr,nc) && !visited[nr][nc] && map[nr][nc]==0) {
					q.add(new point(nr,nc));
					visited[nr][nc]=true;
				}
			}
		}
		
	}
	
	static boolean isin(int r,int c) {
		return r<N && r>=0 && c<M && c>=0;
	}

	

}
