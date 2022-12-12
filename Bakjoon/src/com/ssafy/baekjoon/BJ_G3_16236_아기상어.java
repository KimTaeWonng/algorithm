package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G3_16236_아기상어 {
	
	static int N,map[][],size=2,time;
	static int delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static class fish{
		int pointR;
		int pointC;
		int distance;
		
		public fish(int pointR, int pointC, int distance) {
			this.pointR = pointR;
			this.pointC = pointC;
			this.distance = distance;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		
		fish shark;
		map = new int[N][N];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==9) {
					shark = new fish(r,c,0);  //상어 좌표 확인
					map[r][c]=0;
				}
			}
		}
		
		int exp=0;
		
		
		

	}
	
	
	
	static public boolean help(int size) { //더이상 먹을게 없는가?
		for(int i=0;i<size;i++) {
			if(feed[i][0]!=0) {
				return false;
			}
		}
		return true;
	}

}
