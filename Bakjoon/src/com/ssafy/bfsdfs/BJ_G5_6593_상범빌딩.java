package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_6593_상범빌딩 {

	static class point {
		int l;
		int r;
		int c;

		public point(int l, int r, int c) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
		}

	}

	static int L, R, C,
			deltas[][] = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static int time[][][];
	static String map[][][];
	static boolean visited[][][];
	static point start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		

		while (true) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			//System.out.println(L+" "+R+" "+C);
			if (L == 0 || R == 0 || C == 0)
				break;

			map = new String[L][R][C];
			visited = new boolean[L][R][C];
			time = new int[L][R][C];

			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String[] temp = br.readLine().split("");
					for (int c = 0; c < C; c++) {
						map[l][r][c] = temp[c];
						if (map[l][r][c].equals("S")) {
							start = new point(l, r, c);
						}
						if (map[l][r][c].equals("E")) {
							end = new point(l, r, c);
						}
					}
				}
				br.readLine();	
			}
			
			bfs(start.l, start.r, start.c);
			if(time[end.l][end.r][end.c]==0)
			System.out.println("Trapped!");
			else System.out.println("Escaped in "+time[end.l][end.r][end.c]+" minute(s).");
		}
	}

	public static void bfs(int l, int r, int c) {
		visited[l][r][c] = true;

		Queue<point> q = new LinkedList<>();

		q.add(new point(l, r, c));

		while (!q.isEmpty()) {
			point temp = q.poll();

			for (int d = 0; d < 6; d++) {
				int nl = temp.l + deltas[d][0];
				int nr = temp.r + deltas[d][1];
				int nc = temp.c + deltas[d][2];

				if (isin(nl, nr, nc) && !visited[nl][nr][nc] && !map[nl][nr][nc].equals("#")) {
					if (time[nl][nr][nc] == 0) {
						time[nl][nr][nc] = time[temp.l][temp.r][temp.c] + 1;
						visited[nl][nr][nc] = true;
						q.add(new point(nl, nr, nc));
					}else if(time[nl][nr][nc] > time[temp.l][temp.r][temp.c] + 1) {
						time[nl][nr][nc] = time[temp.l][temp.r][temp.c] + 1;
						visited[nl][nr][nc] = true;
					}
				}
			}
		}

	}

	public static boolean isin(int l, int r, int c) {
		return l < L && l >= 0 && r < R && r >= 0 && c < C && c >= 0;
	}

}
