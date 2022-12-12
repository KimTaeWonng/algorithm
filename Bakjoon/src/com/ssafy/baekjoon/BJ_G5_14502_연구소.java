package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소 {
	
	static class point{
		int r,c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int N, M, map[][],min,sum;
	static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	//벽먼저 세우고 그담에 퍼트리기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		min = 0;
		wall(0);
		
		System.out.println(min);

	}
	
	static void wall(int cnt) {
		
		if(cnt==3) {
			bfs();   //벽 설치 후 바이러스 전파
			min = Math.max(min, sum);
			
			return;
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==0) {
					map[r][c]=1;  //벽 설치
					wall(cnt+1);
					map[r][c]=0;
				}
			}
		}
	}
	
	static void bfs() {
		sum=0;
		Queue<point> p = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
				
		
		int[][] map2 = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map2[i][j] = map[i][j];  //맵 복사하고
				if(map2[i][j]==2) {
					p.offer(new point(i,j)); //그 담에 바이러스 초기 위치 저장해놔
				}
			}
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(map[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
		
		while(!p.isEmpty()) {
			
			point temp = p.poll();
			
			for(int d=0;d<4;d++) {  //가스 가스 가스
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if(isin(nr,nc) && map2[nr][nc]==0) {
					visited[nr][nc]=true;
					map2[nr][nc]=2;
					p.offer(new point(nr,nc));
				}
			}
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map2[i][j]==0) {
					sum++;
				}
			}
		}
	}
	
	static boolean isin(int r,int c) {
		return (r>=0 && r<N && c>=0 && c<M);
	}

}
