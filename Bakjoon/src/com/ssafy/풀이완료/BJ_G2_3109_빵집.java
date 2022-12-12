package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G2_3109_빵집 {
	static int R,C,cnt;
	static char map[][];
	static boolean visit[][];
	static int[][] delta= {{-1,1},{0,1},{1,1}};
	static boolean alreadyUse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st =new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int r=0;r<R;r++) {
			
				map[r]=br.readLine().toCharArray();
			
		}
		
		for(int i=0;i<R;i++) {
			alreadyUse =false;
			visit[i][0] = true;
			pipe(i,0);
		}
		
		System.out.println(cnt);

	}
	
	public static void pipe(int r,int c) {
	
		if(c==C-1) {
			alreadyUse = true;
			cnt++;
			return;
		}
	
		for(int d=0;d<3;d++) {					
			int	rr=r+delta[d][0];
			int cc=c+delta[d][1];
			
			if(rr>=0 && cc>=0 && rr<R && cc<C) {
				if(map[rr][cc]!='x' && !visit[rr][cc]) {
					visit[rr][cc]=true;
					pipe(rr,cc);
					if(alreadyUse) return;
				}
				
			}
			
		}
		
	}

}
