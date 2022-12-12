package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_2239_스도쿠 {
	static class point{
		int r;
		int c;
		
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
		
	}
	
	static int map[][];
	static boolean[] garo,sero,nemo;
	static ArrayList<point> arl = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		map  = new int[9][9];
		
		
		for(int r=0;r<9;r++) {
			String str[] = br.readLine().split("");
			for(int c=0;c<9;c++) {
				map[r][c] = Integer.parseInt(str[c]);
				if(map[r][c]==0) {
					arl.add(new point(r,c));
				}
			}
		}

		dupliPerm(0);		

	}
	
	static void dupliPerm(int cnt) {

		if(cnt==arl.size()) {
			for(int r=0;r<9;r++) {
				for(int c=0;c<9;c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int R = arl.get(cnt).r;
		int C = arl.get(cnt).c;
		
		garo = new boolean[10];
		sero = new boolean[10];
		nemo = new boolean[10];
		boolean check[] = new boolean[10];
		
		for(int c=0;c<9;c++) {
			if(map[R][c]!=0) {
				garo[map[R][c]]=true;   //가로 중복처리
				check[map[R][c]] =true;
			}
		}
		
		for(int r=0;r<9;r++) {
			if(map[r][C]!=0) {
				sero[map[r][C]]=true;    //세로 중복처리
				check[map[r][C]] =true;
			}
		}
		
		int rr = (R/3) *3;    //1~3 4~6 7~9 셋중 어디 소속인지 파악
		int cc = (C/3) *3;
		
		for(int r=rr;r<rr+3;r++) {
			for(int c=cc;c<cc+3;c++) {
				if(map[r][c]!=0) {
					nemo[map[r][c]]=true;  //네모 중복처리
					check[map[r][c]]=true;
				}
			}
		}
		
		
		for(int i=1;i<10;i++) {  //중복 순열
			if(!check[i]) {
				map[R][C] =i;
				dupliPerm(cnt+1);
				map[R][C] =0;
			}
		}
	
	}
		

}
