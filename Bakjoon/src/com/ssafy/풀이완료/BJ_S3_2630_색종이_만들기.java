package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_2630_색종이_만들기 {
	static int map[][],cntB,cntW;
	static boolean blue,white;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int r=0;r<N;r++) {
			st= new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		exp(0,0,N);
		
		System.out.println(cntW+"\n"+cntB);
		
		

	}
	
	static void exp(int r,int c,int size){
		if(check(r,c,size)) {
			if(blue) cntB++;
			if(white) cntW++;
			return;
		}
		size/=2;
		
		exp(r,c,size);				//1번영역 좌상
		exp(r,c+size,size);			//2번영역 우상
		exp(r+size,c,size);			//3번영역 좌하
		exp(r+size,c+size,size);	//4번영역 우하
	}
	
	static boolean check(int R,int C,int size) {
		blue = false;
		white = false;
		for(int r=R;r<R+size;r++) {
			for(int c=C;c<C+size;c++) {
				if(map[r][c]==1) blue = true;
				else white = true;
			}
		}
		
		if(blue && white) return false;
		else if(blue) return true;
		else if(white) return true;
		else return false;
	}

}
