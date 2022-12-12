package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_2578_빙고 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] map = new int[5][5];
		int bingo=0;
		int cnt=0;
		int number=0;
		
		for(int r=0;r<5;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<5;c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				number = Integer.parseInt(st.nextToken());
				for(int r=0;r<5;r++) {
					for(int c=0;c<5;c++) {
						if(map[r][c]==number) {
							cnt++;
							map[r][c] =0;
							if(checkGaro(r, map)) bingo++;
							if(checkSero(c, map)) bingo++;
							if(r==c || r==4-c){
								if(r==c && r==4-c) {
									bingo+=(checkCenter(map));
								}
								if(checkDaegak(r,c,map)) bingo++;
							}
							//System.out.print(number+" ");
							
							if(bingo>=3) {
								System.out.println(cnt);
								System.exit(0);
							}
					
						}
					}
				}
			}
		}

	}
	
	public static boolean isIn(int a,int b) {
		return (a>=0 && b>=0 && a<5 && b<5);
	}
	
	static boolean checkSero(int c, int[][]arr) {
		for(int r=0;r<5;r++) {
			if(arr[r][c]!=0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean checkGaro(int r, int[][]arr) {
		for(int c=0;c<5;c++) {
			if(arr[r][c]!=0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean checkDaegak(int a, int b, int[][]arr) {
		if(a==b) {
			for(int r=0;r<5;r++) {
				int c=r;
				if(arr[r][c]!=0) {
					return false;
				}
			}
		}
		if(a==4-b) {
			for(int r=0;r<5;r++) {
				int c=4-r;
				if(arr[r][c]!=0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static int checkCenter(int[][]arr) {
		int cnt=0;
		boolean one = true;
		boolean two = true;
		
		for(int r=0;r<5;r++) {
			int c=r;
			if(arr[r][c]!=0) {
				one=false;
			}
		}
		
		for(int r=0;r<5;r++) {
			int c=4-r;
			if(arr[r][c]!=0) {
				two=false;
			}
		}
		
		if(one && two) return 2;
		else if(one || two) return 1;
		else return 0;
	}

}
