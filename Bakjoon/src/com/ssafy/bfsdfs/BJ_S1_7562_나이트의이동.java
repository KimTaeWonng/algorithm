package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_7562_나이트의이동 {

	static int N, map[][],
			deltas[][] = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };
	static boolean visited[][], check;
	static point target, start;

	static class point {
		int r;
		int c;
		int cnt;

		public point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visited = new boolean[N][N];
			check = false;

			st = new StringTokenizer(br.readLine());
			start = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			target = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			visited[start.r][start.c] = true;
			if(start.r==target.r && start.c==target.c) {
				System.out.println(0);
			}else {
				bfs(start);
			}
		}

	}

	private static void bfs(point p) {

		Queue<point> po = new LinkedList<BJ_S1_7562_나이트의이동.point>();

		po.add(p);

		while (!po.isEmpty()) {
			
			point temp = po.poll();
			
			for (int d = 0; d < 8; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (isin(nr, nc) && !visited[nr][nc] && !check) {
					
					if (nr == target.r && nc == target.c) {
						System.out.println(temp.cnt+1);
						return;
					}
					visited[nr][nc] = true;
					po.add(new point(nr,nc,temp.cnt+1));
				}
			}
		}

	}

	static boolean isin(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
