package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_2638_치즈 {

		//치즈가 녹을때는 0이 외부와 연결되어있을때
		//0이 0,0와 같은 영역일때 맞닿은 치즈를 모두 녹인다
		//공기와 2변 이상 맞닿은 치즈를 녹이자
		static int N,M,map[][],melt[][];
		static int deltas[][]= {{0,1},{1,0},{0,-1},{-1,0}};
		static boolean visited[][];
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			melt= new int[N][M];
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<M;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			boolean exit=true;
			int cnt=0;
			while(exit) {  //false가 아닐때까지(전부 한시간 뒤 녹는 치즈만 있을 떄까지) 반복
				
				for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						visited[r][c]=false;  //매번 방문 초기화
						melt[r][c]=0;		  //매번 맞닿은 횟수 초기화
					}
				}
				
				exit=false;
				
				bfs(0,0);  //치즈 녹엿
				
				for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						if(melt[r][c]>=2) {     //1시간 뒤 녹는 치즈 개수를 확인
							map[r][c]=0;
						}
					}
				}
				
				
				for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						if(map[r][c]==1) {   //아직 녹지않는 치즈가 1개라도 있으면 나가지않는다
							exit=true;
						}
					}
				}											
				cnt++;   //cnt=시간
				
			}
			
			System.out.println(cnt);

		}
		
		static void bfs(int r,int c) {
			visited[r][c] = true;
			
			for(int d=0;d<4;d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				if(isin(nr,nc) && !visited[nr][nc] && map[nr][nc]==0) {   // 0일때는 bfs계속 해나감
					bfs(nr,nc);
				}else if(isin(nr,nc) && map[nr][nc]==1) {  // 치즈가 공기와 맞닿을 때마다 그 횟수를 체크해준다
					melt[nr][nc]++;
				}
			}
		}
		
		static boolean isin(int r,int c) {
			return (r>=0 && r<N && c>=0 && c<M);
		}

}
