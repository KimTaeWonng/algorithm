package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_11724_연결요소의개수 {

	static int N, M;
	static int[] link;

	static int findSet(int a) {
		if (a == link[a]) {
			return a;
		} else
			return link[a] = findSet(link[a]);
	}

	static void unionSet(int a, int b) {
		int aR = findSet(a);
		int bR = findSet(b);

		if (aR == bR) {
			return;
		} else {			
			link[bR] = aR;		
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		link = new int[N+1];

		for (int i = 1; i < N+1; i++) {
			link[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a, b);
		}


		int cnt = 0;
		ArrayList<Integer> go = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			//System.out.println(findSet(i));
			if (!go.contains(findSet(i))) {
				cnt++;
				go.add(findSet(i));
			}
		}

		System.out.println(cnt);

	}

}
