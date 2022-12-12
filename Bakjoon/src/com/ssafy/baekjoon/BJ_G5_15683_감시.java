package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_15683_감시 {
	static int R,C,map[][],delta[][]= {{0,1},{0,-1},{1,0},{-1,0}};
	static int cnt,Min,ccTV;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int r=0;r<R;r++) {
			st= new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
				if(map[r][c]!=0 && map[r][c]!=6){
					ccTV++;
				}
			}
		}
		
		cnt=0;
		Min= Integer.MAX_VALUE;
		
		cctv(0);
		
		System.out.println(Min);
		

	}
	
	static void cctv(int num,int r,int c) {
		if(num==ccTV) {
			for(int a=0;a<R;a++) {
				for(int b=0;b<C;b++) {
					if(map[a][b]==0) {
						cnt++;
					}
				}
			}
			Min = Math.min(Min, cnt);
			return;
		}  //위에가 기저조건
		
		
		if(map[r][c]!=0 && map[r][c]!=6) {
			switch(map[r][c]) {
				case 1:
			}
		}else {
			if(r<R-1 && c<C-1) cctv(num,r,c+1);
			else if(r<R-1) cctv(num,r+1,0);
		}
			
		
		
		
		
	}
	
	

}
