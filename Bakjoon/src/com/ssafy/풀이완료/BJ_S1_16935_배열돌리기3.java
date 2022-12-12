package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_16935_배열돌리기3 {
	static int[][] map;
	static int[][] map2;
	static int[][] map3,map4,map5,map6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int order = Integer.parseInt(st.nextToken());
		map = new int[N][M];		
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int o=0;o<order;o++) {
			int k = Integer.parseInt(st.nextToken());
			switch(k){
				// 1번
			case 1:
				for(int r=0;r<N/2;r++) {
					for(int c=0;c<M;c++) {
						int temp = map[r][c];
						map[r][c] = map[N-r-1][c];
						map[N-r-1][c]= temp;
					}
				}
				break;
				// 2번
			case 2:
				for(int r=0;r<N;r++) {
					for(int c=0;c<M/2;c++) {
						int temp = map[r][c];
						map[r][c] = map[r][M-c-1];
						map[r][M-c-1]= temp;
					}
				}
				break;
				// 3번
			case 3:
				int temp = M;
				M= N;
				N = temp;
				map2 = new int[N][M];
				for(int r=0;r<map.length;r++) {
					for(int c=0;c<map[0].length;c++) {
						map2[c][map.length-r-1]= map[r][c];
					}
				}				
				map = map2;
				break;
				// 4번
			case 4:
				int temp2 = M;
				M= N;
				N = temp2;
				map2 = new int[N][M];
				for(int r=0;r<map.length;r++) {
					for(int c=0;c<map[0].length;c++) {
						map2[map[0].length-c-1][r] = map[r][c];
					}
				}
				map = map2;
				break;
				// 5번
			case 5:
				map3 = new int[N/2][M/2];
				map4 = new int[N/2][M/2];				
				map5 = new int[N/2][M/2];
				map6 = new int[N/2][M/2];
				for(int r=0;r<N/2;r++) {
					for(int c=0;c<M/2;c++) {
						map3[r][c] = map[r][c];
						map4[r][c] = map[r][c+M/2];
						map5[r][c] = map[r+N/2][c+M/2];
						map6[r][c] = map[r+N/2][c];
					}
				}
				
				for(int r=0;r<N/2;r++) {
					for(int c=0;c<M/2;c++) {
						map[r][c] = map6[r][c];						
					}
				}
				for(int r=0;r<N/2;r++) {
					for(int c=M/2;c<M;c++) {
						map[r][c] = map3[r][c-M/2];

					}
				}
				
				for(int r=N/2;r<N;r++) {
					for(int c=0;c<M/2;c++) {
						map[r][c] = map5[r-N/2][c];
					}
				}
				
				for(int r=N/2;r<N;r++) {
					for(int c=M/2;c<M;c++) {
						map[r][c] = map4[r-N/2][c-M/2];
					}
				}
				break;
			case 6:
				map3 = new int[N/2][M/2];
				map4 = new int[N/2][M/2];				
				map5 = new int[N/2][M/2];
				map6 = new int[N/2][M/2];
				for(int r=0;r<N/2;r++) {
					for(int c=0;c<M/2;c++) {
						map3[r][c] = map[r][c];
						map4[r][c] = map[r][c+M/2];
						map5[r][c] = map[r+N/2][c+M/2];
						map6[r][c] = map[r+N/2][c];
					}
				}
				
				for(int r=0;r<N/2;r++) {
					for(int c=0;c<M/2;c++) {
						map[r][c] = map4[r][c];						
					}
				}
				for(int r=0;r<N/2;r++) {
					for(int c=M/2;c<M;c++) {
						map[r][c] = map5[r][c-M/2];

					}
				}
				
				for(int r=N/2;r<N;r++) {
					for(int c=0;c<M/2;c++) {
						map[r][c] = map3[r-N/2][c];
					}
				}
				
				for(int r=N/2;r<N;r++) {
					for(int c=M/2;c<M;c++) {
						map[r][c] = map6[r-N/2][c-M/2];
					}
				}
				break;
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		

	}

}
