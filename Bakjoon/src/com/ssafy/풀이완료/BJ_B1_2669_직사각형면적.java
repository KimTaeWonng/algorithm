package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B1_2669_직사각형면적 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] map = new int[101][101];
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			
			for(int r=a;r<R;r++) {
				for(int c=b;c<C;c++) {
					map[r][c]=1;
				}
			}
			
		}
		int cnt=0;
		for(int r=0;r<101;r++) {
			for(int c=0;c<101;c++) {
				if(map[r][c]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
