package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {
	static int N,cnt,map[][],deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean visit[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int max = 0;
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				max = Math.max(map[r][c], max);  //가장 높은 건물의 높이를 미리 재두고
			}
		}
		int answer=0;
		
		for(int i=0;i<max;i++) {   //비가 아예안오는 경우도 있다.
			cnt=0;
			visit = new boolean[N][N];
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(map[r][c]>i && !visit[r][c]) {   //비온뒤 잠기지 않았으면
						bfs(r,c,i);
						cnt++;
					}
				}
			}
			
			answer = Math.max(answer, cnt);  //매 침수 높이때 마다 최대값을 비교
		}
		
		System.out.println(answer);
	}
	
	static void bfs(int r,int c,int i) {   //같은 구역 내 잠기지 않은 지역을 전부 탐색한다
		visit[r][c] = true;
		for(int d=0;d<4;d++) {   
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && map[nr][nc]>i && !visit[nr][nc]) {
				bfs(nr,nc,i);
			}
		}
	}
	
	static boolean isIn(int r,int c) {
		return (r>=0 && r<N && c>=0 && c<N);
	}

}
