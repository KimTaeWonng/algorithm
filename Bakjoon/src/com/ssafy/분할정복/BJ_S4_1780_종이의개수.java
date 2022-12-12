package com.ssafy.분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_1780_종이의개수 {
	
	static int minus,zero,plus;
	static int N, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bunhal(0,0,N);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void bunhal(int r, int c, int N) {

		if(check(r,c,N)) {
			switch(map[r][c]) {
			case -1:
				minus++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				plus++;
				break;
			}
			
			return;
		}
		
		
		int size = N/3;
		
		bunhal(r,c,size); 							//9등분의 네모 중 좌상단
		bunhal(r,c+size,size);						//상단 중앙
		bunhal(r,c+size+size,size);					//우상단
		
		bunhal(r+size,c,size);						//좌중단
		bunhal(r+size,c+size,size);					//중앙
		bunhal(r+size,c+size+size,size);			//우중단
		
		bunhal(r+size+size,c,size);					//좌하단
		bunhal(r+size+size,c+size,size);			//하단 중앙
		bunhal(r+size+size,c+size+size,size);		//우하단
		
	}

	private static boolean check(int r, int c, int N) { // 다같은수인지 판별
		int checking = map[r][c];
		
		
		for(int R=r;R<r+N;R++) {
			for(int C=c;C<c+N;C++) {
				if(map[R][C]!=checking) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	

}
