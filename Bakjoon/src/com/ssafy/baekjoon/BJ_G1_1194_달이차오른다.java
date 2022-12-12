package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1194_달이차오른다 {
	
	static class Minsik{
		int r,c;
		int keys;
		
		public Minsik(int r, int c, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.keys = keys;
		}
		
		public boolean hasKey(char gate) {
			return (keys & (1<<(gate-'A')))>0;  //문과 만났을때 
		}
		
		public void updateKey(char key) {  //키를 주웠을때
			keys |= (1<<(key-'a'));
		}
		
	}
	
	static int N,M;
	static int deltas[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static char map[][];
	static Minsik ms;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int r=0;r<N;r++) {
			char[] ch = br.readLine().toCharArray();
			for(int c=0;c<N;c++) {
				if(ch[c]=='0') {
					ms = new Minsik(r,c,0);
				}
				map[r][c] = ch[c];
			}
		}
		
		System.out.println(bfs());

	}
	
	public static int bfs() {
		//준비물
		boolean[][][] visited = new boolean[N][M][1<<6]; //2의 6승은 1<<6과 같음
		Queue<Minsik> q = new LinkedList<>();
		
		//
		q.offer(ms);
		visited[ms.r][ms.c][ms.keys] =true;
		
		int cnt=0;
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int i=0;i<size;i++) {
				
				Minsik temp = q.poll();
				
				if(map[temp.r][temp.c]=='1') {  //출구를 찾은 상태
					return cnt;
				}
				
				if(map[temp.r][temp.c]>='a' && map[temp.r][temp.c]<='f') {  // 키를 주웠다
					temp.updateKey(map[temp.r][temp.c]);
				}
				
				for(int d=0;d<4;d++) {
					int nr = temp.r+deltas[d][0];
					int nc = temp.c+deltas[d][1];
					if(isin(nr,nc) && !visited[nr][nc][temp.keys] && map[nr][nc]!='#') {
						if(map[nr][nc]>='A' && map[nr][nc]<='F' && !temp.hasKey(map[nr][nc])) {
							continue;
						}
						
						visited[nr][nc][temp.keys] = true;
						q.offer(new Minsik(nr, nc, temp.keys));
						
					}
				}
			}
			
		}
		
		return -1;
	}
	
	public static boolean isin(int r,int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

}
