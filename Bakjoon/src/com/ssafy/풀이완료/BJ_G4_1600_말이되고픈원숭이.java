package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_1600_말이되고픈원숭이 {
	
	static int horse[][] = {{-2,-1},{-1,-2},{2,-1},{1,-2},{2,1},{1,2},{-2,1},{-1,2}};
	static int deltas[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	static int N,M,K,map[][],cnt;
	static boolean visited[][][];
	
	static class monkey{
		int r;
		int c;
		int k;
		int move;
		
		public monkey(int r, int c, int k, int move) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;        //말처럼 움직인 횟수
			this.move = move;  //이동 횟수
		}
		
		
	}
			

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];    // K+1개의 평행세계를 갖는 방문처리
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = Integer.MAX_VALUE;
		
		bfs(0,0,0);
		
		if(cnt==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(cnt);

	}
	
	static void bfs(int r,int c,int k) {
		visited[r][c][k] = true;
		
		Queue<monkey> m = new LinkedList<>();
		m.offer(new monkey(r,c,k,0));
		
		while(!m.isEmpty()) {
			monkey temp = m.poll();
			if(temp.r==N-1 && temp.c==M-1) {
				cnt = Math.min(cnt, temp.move);  //도착하면 최소값인지 판단 
				return;  //목적지 도착
			}
			
			for(int d=0;d<4;d++) {  //원숭이 무빙 
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if(isin(nr,nc) && !visited[nr][nc][temp.k]&&map[nr][nc]==0) {
					visited[nr][nc][temp.k] = true;
					m.offer(new monkey(nr,nc,temp.k,temp.move+1));  
				}
			}
			
			if(temp.k<K) {   // horse 무빙
				for(int h=0;h<8;h++) {
					int nr = temp.r + horse[h][0];
					int nc = temp.c + horse[h][1];
					if(isin(nr,nc) && !visited[nr][nc][temp.k+1] && map[nr][nc]==0) {  //horse점프를 한번이라도 하는 순간 temp.k+1의 차원으로 이동한다
						visited[nr][nc][temp.k+1]=true;
						m.offer(new monkey(nr,nc,temp.k+1,temp.move+1)); 
					}
				}
			}
		}
		return;
		
	}
	
	static boolean isin(int r,int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

}
