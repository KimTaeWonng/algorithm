package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2178_미로탐색 {

	static int map[][], N, M, deltas[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean visited[][];
	
	static class point{
		int r;
		int c;
		
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}

		bfs();

		System.out.println(map[N-1][M-1]);
	}

	static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			point temp = q.poll();			

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (isin(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
					q.add(new point(nr,nc));
					map[nr][nc] = map[temp.r][temp.c]+1;
					visited[nr][nc]=true;
				}
			}
		}

	}

	static boolean isin(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
