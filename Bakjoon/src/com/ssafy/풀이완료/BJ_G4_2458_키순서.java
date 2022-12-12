package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_2458_키순서 {

	// findset 개수 <=아님
	// 나보다 큰거 + 작은거 = N-1이면 안다

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], (500 * 499 / 2)); // 이거보단 안커져
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1; // 둘은 연결됨 (r은 c보다 작게)
		}

		for (int i = 1; i <= N; i++) { // 경 출 도
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue; // 경==출 할필요없음
				for (int k = 1; k <= N; k++) {
					if (j == k || i == k)
						continue; // 경==도 or 출==도 할필요없음
					if (map[j][k] > map[j][i] + map[i][k]) { // 출->도 보다 출->경->도 가 더 빠르면
						map[j][k] = map[j][i] + map[i][k]; // 갱신
					}
				}
			}
		}
		// 여기까지 플로이드-워셜

//			for(int r=1;r<=N;r++) {
//				for(int c=1;c<=N;c++) {
//					System.out.print(map[r][c]+" ");
//				}
//				System.out.println();
//			}

		int ans = 0; // 나보다 크거나 작은게 총합 N-1개 존재하면 내 위치를 정확히 알수있음
		for (int i = 1; i <= N; i++) {
			int up = 0;
			int down = 0;
			for (int j = 1; j <= N; j++) {
				if (map[i][j] < (500 * 499 / 2)) {
					up++;
				} else if (map[j][i] < (500 * 499 / 2)) {
					down++;
				}
			}
			if (up + down == N - 1) {
				ans++;
			}
		}

		System.out.println(ans);

	}

}
