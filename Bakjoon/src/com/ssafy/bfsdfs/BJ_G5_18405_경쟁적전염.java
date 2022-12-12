package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_18405_경쟁적전염 {
	
	static int N,K,map[][],deltas[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visited[][];
	static int cnt;	
	
	static class point{
		int r;
		int c;
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		int Y = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0;i<S;i++) {
			for(int j=1;j<=K;j++) {
				bfs(j);
				
				if(map[X][Y]!=0) break;  //시간초과나서 이거 추가함
			}
			if(map[X][Y]!=0) break;  // 시간초과나서 이거 추가함
		}
		
		System.out.println(map[X][Y]);
			
		
	}
	
	static void bfs(int v) {
		Queue<point> virus = new LinkedList<>();
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==v) {
					virus.add(new point(r,c));
				}
			}
		}
		
		while(!virus.isEmpty()) {
			
			point temp = virus.poll();
			
			for(int d=0;d<4;d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				
				if(isin(nr,nc) && map[nr][nc]==0) {
					map[nr][nc] = v;
				}
			}
			
		}
	}

	private static boolean isin(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
