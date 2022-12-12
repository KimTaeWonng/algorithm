package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_10026_적록색약 {
	
	static int N,delta[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visit[][];
	static char map[][],map2[][];
			

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N= Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		
		map2 = new char[N][N];  //적록 색맹용
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]=='G' || map[r][c]=='R') {    //적록 색맹은 이렇게 보입니다.
					map2[r][c]='R';					
				}else map2[r][c]='B';
			}
		}
		
		
		int normal=0;  //정상인이 보이는 구역
		int eyebreak=0; // 적록색맹이 보이는구역
		
		visit = new boolean[N][N];
		//visit[0][0]= true;
		for(int r=0;r<N;r++) {        //일반인 구역 구하기
			for(int c=0;c<N;c++) {
				if(!visit[r][c]) {
					dfs(r,c);
					normal++;
				}
			}
		}
		
		
		visit = new boolean[N][N];
		for(int r=0;r<N;r++) {        //색약 구역 구하기
			for(int c=0;c<N;c++) {
				if(!visit[r][c]) {
					dfs2(r,c);
					//System.out.println(1);
					eyebreak++;
				}
			}
		}
		
		System.out.println(normal+" "+eyebreak);
		
		
		
	}
	
	static public void dfs(int r,int c) {     //일반인
		visit[r][c] =true;
		char temp = map[r][c];
		
		for(int d=0;d<4;d++) {
			int nr = r+delta[d][0];
			int nc = c+delta[d][1];
			
			if(isin(nr,nc,N) && !visit[nr][nc] && map[nr][nc]==temp) {				
				dfs(nr,nc);
			}
		}
	
	}
	
	static public void dfs2(int r,int c) {     //색맹용
		visit[r][c] =true;		
		char temp = map2[r][c];
		
		for(int d=0;d<4;d++) {
			int nr = r+delta[d][0];
			int nc = c+delta[d][1];
			
			if(isin(nr,nc,N) && !visit[nr][nc] && map2[nr][nc]==temp) {
				dfs2(nr,nc);
			}
		}
	}
	
	static public boolean isin(int a,int b,int N) {
		return (a<N && a>=0 && b<N && b>=0);
	}

}
