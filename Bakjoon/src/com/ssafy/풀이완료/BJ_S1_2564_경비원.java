package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {
	
	static int map[][],N,M, store=1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		int T = Integer.parseInt(br.readLine());
						
		for(int t=0;t<T;t++) {   //가게들 위치
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			checkStore(a,b);
		}
		
		st = new StringTokenizer(br.readLine());		
		int a =Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		
		switch(a) {   //동근이 위치
		case 1:
			map[0][b] = -1;
			break;
		case 2:
			map[N][b] = -1;
			break;
		case 3:
			map[b][0] = -1;
			break;
		case 4:
			map[b][M] = -1;
			break;
		}
		
		int answer=0;
		for(int t=1;t<=T;t++) {
			answer+=checkLength(a, b, t);
		}
		
		System.out.println(answer);
		
		
		/*for(int r=0;r<=N;r++) {
			for(int c=0;c<=M;c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}*/
		

	}
	
	static void checkStore(int a, int b) {
		switch(a) {
		case 1:
			map[0][b] = store++;
			break;
		case 2:
			map[N][b] = store++;
			break;
		case 3:
			map[b][0] = store++;
			break;
		case 4:
			map[b][M] = store++;
			break;
		}
	}
	
	static int checkLength(int a,int b, int i) {
		int routeA=0;
		int MAX;
		for(int r=0;r<=N;r++) {
			for(int c=0;c<=M;c++) {
				if(map[r][c]==-1) {
					int rr=r, cc=c;
					if(rr==0 || rr==N) {              //북쪽 혹은 남쪽에 동근이
						while(map[rr][cc]!=i) {
							while(!(cc<=0) && map[rr][cc]!=i) {
								routeA++;
								cc-=1;
							}
							if(rr==0) {
								while(!(rr>=N) &&map[rr][cc]!=i) {
									routeA++;
									rr+=1;
								}
							}else {
								while(!(rr<=0) && map[rr][cc]!=i){
									routeA++;
									rr-=1;
								}
							}
							while(!(cc>=M) && map[rr][cc]!=i) {
								routeA++;								
								cc+=1;
							}
							
							if(rr==0) {
								while(!(rr>=N) && map[rr][cc]!=i) {
									routeA++;
									rr+=1;
								}
							}else {
								while(!(rr<=0) && map[rr][cc]!=i){
									routeA++;
									rr-=1;
								}
							}
							
							while(!(cc<=0) && map[rr][cc]!=i) {
								routeA++;
								cc-=1;
							}							
						}
						
					}
					
					if(cc==0 || cc==M) {          //동쪽 혹은 서쪽에 동근이
						while(map[rr][cc]!=i) {
							while(!(rr<=0) && map[rr][cc]!=i){
								routeA++;
								rr-=1;
							}
							if(cc==0) {
								while(!(cc>=M) && map[rr][cc]!=i) {
									routeA++;								
									cc+=1;
								}
							}else {
								while(!(cc<=0) && map[rr][cc]!=i) {
									routeA++;
									cc-=1;
								}
							}
							while(!(rr>=N) && map[rr][cc]!=i) {
								routeA++;
								rr+=1;
							}
							
							if(cc==0) {
								while(!(cc>=M) && map[rr][cc]!=i) {
									routeA++;								
									cc+=1;
								}
							}else {
								while(!(cc<=0) && map[rr][cc]!=i) {
									routeA++;
									cc-=1;
								}
							}
							while(!(rr>=N) && map[rr][cc]!=i) {
								routeA++;
								rr+=1;
							}
							
							
						}
					}
					
					
					
				}
				
			}
		}
		
		if(routeA >(N+M)) {
			MAX = 2*(N+M)-routeA;
		}else MAX = routeA;
		
		return MAX;
	}

}
