package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_15686_치킨배달 {
	static int N,M,map[][],answer,Min,cntC,cntH;
	static Point pH[],pC[],select[];
	
	static class Point{
		int pointR;
		int pointC;
		
		public Point(int pointR, int pointC) {
			this.pointR = pointR;
			this.pointC = pointC;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		cntH=0;
		cntC=0;
		for(int r=0;r<N;r++) {    
			st=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) {    //맵에 존재하는 치킨가게와 가정집 개수 파악
					cntH++; 
				}
				if(map[r][c]==2) {    
					cntC++;
				}
			}
		}
		
		pH = new Point[cntH];
		pC = new Point[cntC];    //나중에 거리 구하기 위해 미리 선언한 객체형태로 생성
		
		int a=0,b=0;
		for(int r=0;r<N;r++) {     
			for(int c=0;c<N;c++) {
				if(map[r][c]==1) {
					pH[a++] = new Point(r,c);    //집은 pH에, 치킨은 pC에 모든 좌표값 넣기
				}
				if(map[r][c]==2) {
					pC[b++] = new Point(r,c);
				}
			}
		}

		Min = Integer.MAX_VALUE;
		
		select = new Point[M];
		
		comb(0,0);
		
		bw.write(String.valueOf(Min));
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static public void comb(int cnt,int start) {
		if(cnt==M) {
			int sum=0;			
			for(int i=0;i<cntH;i++) {
				int min=Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {
					//선택된 치킨가게에 대해 모든 집들의 치킨 거리를 구하고, 최소값을 도출
					min = Math.min(min, Math.abs(pH[i].pointC-select[j].pointC)+Math.abs(pH[i].pointR-select[j].pointR));
				}
				sum+=min;
			}
			
			Min = Math.min(sum, Min);
			return;
			
		}
		
		
		for(int i=start;i<cntC;i++) {
			select[cnt]=pC[i];
			comb(cnt+1,i+1);
		}
	}

}
