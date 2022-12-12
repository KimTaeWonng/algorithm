package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_4485_젤다 {

	static class point implements Comparable<point> {
		int r;
		int c;
		int weight;

		public point(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	static int N, map[][], rupoor[][], min,cnt=1;
	static int deltas[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0) break; //마지막 입력
			
			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			rupoor = new int[N][N];
			boolean visited[][] = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					rupoor[r][c] = Integer.MAX_VALUE;
				}
			}
			rupoor[0][0] = map[0][0]; 
			//여기까지 입력 및 초기화
			
			System.out.print("Problem " + cnt + ": ");
			System.out.println(dij());
			cnt++;
		}

	}

	public static int dij() {

		PriorityQueue<point> pq = new PriorityQueue<>();
		pq.add(new point(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			point temp = pq.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if (isin(nr, nc) && rupoor[nr][nc] > rupoor[temp.r][temp.c] + map[nr][nc]) { // 새로운 경로의 값이 더 작으면
					rupoor[nr][nc] = rupoor[temp.r][temp.c] + map[nr][nc];
					pq.add(new point(nr, nc, rupoor[nr][nc])); // 바꿔주고 큐에 넣어줌
				}
			}

		}

		return rupoor[N - 1][N - 1];
	}

	static boolean isin(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}

}
