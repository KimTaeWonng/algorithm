package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S1_2583_영역구하기 {
	
	static int N,M,K,cnt,map[][],deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean visit[][];
	static ArrayList<Integer> arl;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<K;i++) {   					//모눈종이를 덮는 직사각형들 입력
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			for(int r=r1;r<r2;r++) {
				for(int c=c1;c<c2;c++) {
					map[r][c]=1;
				}
			}
		}
		

		arl = new ArrayList<>();
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==0 && !visit[r][c]) {
					cnt=1;			//처음 시작하는 모눈을 세면서 시작
					bfs(r,c);
					arl.add(cnt);	//한 구역에대해 bfs가 끝나면 리스트에 넣는다.
				}
			}
		}
		
		System.out.println(arl.size());
		
		Collections.sort(arl);   			//오름차순 출력을 위한 정렬 
		
		for(int i=0;i<arl.size();i++) {
			System.out.print(arl.get(i)+" ");
		}

	}
	
	static void bfs(int r, int c) {			//하나의 구역에 대해 계속 bfs돌면서 구역 내 존재하는 모눈 확인
		visit[r][c] = true;
		for(int d=0;d<4;d++) {
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if(nr>=0 && nc>=0 && nr<N && nc<M && map[nr][nc]==0 && !visit[nr][nc]) {
				cnt++;
				bfs(nr,nc);
			}
		}
	}

}
