package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_2477_참외밭 {
	
	static int[][] map = new int[6][2];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int checkG,checkS;


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int chamE = Integer.parseInt(br.readLine());   

		for(int i=0;i<6;i++) {
			st =  new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int MAXG=0, MAXS=0;
		for(int i=0;i<6;i++) {
			
			if((map[i][0]==1 ||map[i][0]==2) && map[i][1] > MAXG) {
				MAXG= map[i][1];
				checkG=i;
			}
			
			if((map[i][0]==3 ||map[i][0]==4) && map[i][1] > MAXS) {
				MAXS= map[i][1];
				checkS=i;
			}
		}
		int r,c;
		if(checkG==0) {
			c= Math.abs(map[5][1] - map[1][1]);
		}else if(checkG==5) {
			c = Math.abs(map[4][1] - map[0][1]);
		}else {
			c = Math.abs(map[checkG+1][1] - map[checkG-1][1]);
		}
		
		if(checkS==0) {
			r= Math.abs(map[5][1] - map[1][1]);
		}else if(checkS==5) {
			r = Math.abs(map[4][1] - map[0][1]);
		}else {
			r = Math.abs(map[checkS+1][1] - map[checkS-1][1]);
		}
		
		int answer = (MAXG*MAXS-r*c)*chamE;
		
		System.out.println(answer);
		
		
		
		
		
	}
	
	

}
