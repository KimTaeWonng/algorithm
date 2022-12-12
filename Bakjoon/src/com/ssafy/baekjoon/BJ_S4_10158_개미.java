package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_10158_개미 {
	static int w,h,p,q,t,map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		w= Integer.parseInt(st.nextToken());
		h= Integer.parseInt(st.nextToken());  //맵 크기
		
		map= new int[w+1][h+1];
		
		st = new StringTokenizer(br.readLine()); 
		
		p= Integer.parseInt(st.nextToken());
		q= Integer.parseInt(st.nextToken());  //개미 초기 좌표
		
		t= Integer.parseInt(br.readLine());   //시간
	}
	
	public static void ant() {
		int collision = 0;
		int time = 0;
		while(time<t) {
			if(p==w || q==h || p==0 || q==0) {
				collision++;
			}
			int version = collision%4;
			switch(version) {
			case 0:
				time++;
				p++;q++;
				break;
			case 1:
				time++;
				p--;q++;
			}
		}
		
	}

}
