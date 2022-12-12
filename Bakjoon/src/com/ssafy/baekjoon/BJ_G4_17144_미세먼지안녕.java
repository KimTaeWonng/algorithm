package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17144_미세먼지안녕 {

	static int R, C, T, map[][],map2[][], delta[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }, cnt;
	static air[] a = new air[2];
	static Queue<dust> q = new LinkedList<>();

	static class air {
		int R;
		int C;

		public air(int r, int c) {
			super();
			R = r;
			C = c;
		}

	}

	static class dust {
		int R;
		int C;
		//int amount;

		public dust(int r, int c) {
			super();
			R = r;
			C = c;
			//this.amount = amount;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		map2= new int[R][C];

		boolean check = false; // 공기청정기 체크용
		a = new air[2];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (!check && map[r][c] == -1) {
					a[0] = new air(r, c); // 공기정청기 위쪽 부분
					a[1] = new air(r + 1, c); // 아래쪽 부분
					check = true;
				} else if (map[r][c] != 0) {
					q.offer(new dust(r, c));
				}
			}
		}

		for (int t = 0; t < T; t++) {
			cnt=0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]!=0 && map[r][c]!=-1) cnt++; // 맵에 존재하는 퍼질 수 있는 미세먼지의 개수
				}
			}
			//System.out.println(cnt + " cnt");
			dustDiffusion();
			airCleaning();
		}
		
		int answer=0;
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				System.out.print(map[r][c]+" ");
				if(map[r][c] != -1) answer +=map[r][c];
			}	
			System.out.println();
		}
		
		System.out.println(answer);
		

	}

	static public void dustDiffusion() {
		int k = 0;
		map2 = new int[R][C];
		while (k < cnt+1) {
			dust temp = q.poll();
			int amount = map[temp.R][temp.C] / 5;
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.R + delta[d][0];
				int nc = temp.C + delta[d][1];				
				if (isin(nr, nc) && map[nr][nc] != -1) {
					map2[nr][nc] +=amount;
					map[temp.R][temp.C] -= amount;
					map[nr][nc] += amount;
					if(map[temp.R][temp.C]>=5) q.offer(new dust(temp.R,temp.C));
					if(map[nr][nc]>=5) q.offer(new dust(nr, nc));
				}
			}
			k++;
		}

	}

	static public void airCleaning() {
		//위쪽 클리닝
		for(int i=0;i<R;i++) {
			if(a[0].R-2-i<0) break;
			map[a[0].R-1-i][0] = map[a[0].R-2-i][0]; 
		}
		for(int i=0;i<C-1;i++) {
			map[0][i]=map[0][i+1];
		}
		for(int i=0;i<R;i++) {
			if(a[0].R<=i) break;
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i=C-1;i>1;i--) {
			map[a[0].R][i] = map[a[0].R][i-1];
		}
		map[a[0].R][1]=0;
		
		//아래쪽 클리닝
		for(int i=0;i<R;i++) {
			if(a[1].R+2+i>=R) break;
			map[a[1].R+1+i][0] = map[a[1].R+2+i][0]; 
		}
		for(int i=0;i<C-1;i++) {
			map[R-1][i]=map[R-1][i+1];
		}
		for(int i=R-1;i>0;i--) {
			if(a[1].R>=i) break;
			map[i][C-1] = map[i-1][C-1];
		}
		for(int i=C-1;i>1;i--) {
			map[a[1].R][i] = map[a[1].R][i-1];
		}
		map[a[1].R][1]=0;
		
		
		

	}

	static public boolean isin(int r, int c) {
		return (r >= 0 && c >= 0 && r < R && c < C);
	}

}
