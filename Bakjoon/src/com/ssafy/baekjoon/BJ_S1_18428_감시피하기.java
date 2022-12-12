package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_18428_감시피하기 {
	static class teacher{
		int r,c;

		public teacher(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int N,deltas[][]= {{0,1},{0,-1},{1,0},{-1,0}};
	static String[][] map;
	static boolean Yes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine());			
			for(int c=0;c<N;c++) {
				map[r][c] = st.nextToken();
			}
		}
		
		
//		for(int r=0;r<N;r++) {
//			for(int c=0;c<N;c++) {			
//			System.out.print(map[r][c]);
//			}
//			System.out.println();
//		}
		
		dfs(0);
		
		if(Yes) System.out.println("YES");
		else System.out.println("NO");
		

	}
	
	static void dfs(int cnt) {
		
		if(cnt==3) {
			go();
			return;
		}
		
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c].equals("X")) {
					map[r][c]="O";
					dfs(cnt+1);
					map[r][c]="X";
				}
			}
		}
		
		
	}
	
	static void go() {
		if(Yes) {
			return;
		}
		
		Yes=true;
		boolean visited[][] = new boolean[N][N];
		Queue<teacher> t = new LinkedList<>();
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c].equals("T")) {
					t.add(new teacher(r,c));
				}
			}
		}
		int cnt=1;
		while(!t.isEmpty()) {  //모든 선생님에 대해 처리
			if(!Yes) {
				break;
			}
			teacher temp = t.poll();
//			System.out.println(cnt+++" "+temp.r+" "+ temp.c);
			
			
			for(int d=0;d<4;d++) {
				int rr = temp.r;
				int cc = temp.c;
				while(true) {
					int nr = rr + deltas[d][0];
					int nc = cc + deltas[d][1];
					if(isin(nr,nc) && map[nr][nc].equals("S")) {
						Yes=false;
						break;
					}else if(isin(nr,nc) && map[nr][nc].equals("X")) {
						rr = nr;
						cc = nc;
					}else {
						break;
					}
				}
				
			}
			
			
		}
		
	}
	
	static boolean isin(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}

}
