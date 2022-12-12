package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1987_알파벳 {
	
	static char[][] map;
	static int R,C,cnt=0;
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[] visit;
	static int MAX = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		visit = new boolean[26]; // A=65;
		
		for(int r=0;r<R;r++) {
			map[r]=br.readLine().toCharArray();
		}
				
		go(0,0);
		
		System.out.println(MAX);

	}
	
	public static void go(int r,int c) {
		
		if(visit[map[r][c]-65]) {			
				cnt=0;
				for(int i=0;i<26;i++) {
					if(visit[i]) {
						cnt++;
					}
				}
				MAX = Math.max(MAX, cnt);
				return;			
		}
		
		
		visit[map[r][c]-65]=true;
		for(int d=0;d<4;d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				go(nr,nc);							
			}			
		}
		visit[map[r][c]-65]=false;
	}

}
