package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농배추 {
	static int R, C, map[][], delta[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean visit[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[R][C];
			visit = new boolean[R][C];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}  //여기까지 입력 받기

			int cnt = 0;

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == 1 && !visit[r][c]) {
						visit[r][c] = true;
						dfs(r, c);
						cnt++;  //인접한 배추들의 한 영역을 끝내면 cnt 증가
					}
				}
			}

			System.out.println(cnt);
		}

	}

	static void dfs(int r, int c) {  
		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 1 && !visit[nr][nc]) {  //인접한  배추를 모두 확인할때까지
				visit[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

}
