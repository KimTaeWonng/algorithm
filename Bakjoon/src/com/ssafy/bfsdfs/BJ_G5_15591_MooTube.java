package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_15591_MooTube {

	static class Moo {
		int number;
		int usado;

		public Moo(int number, int usado) {
			super();
			this.number = number;
			this.usado = usado;
		}

	}

	static int N, Q, K, V;
	static ArrayList<Moo> moo[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		moo = new ArrayList[N + 1];

		for (int i = 1; i < N+1; i++) {
			moo[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int ber = Integer.parseInt(st.nextToken());
			int usado = Integer.parseInt(st.nextToken());
			moo[num].add(new Moo(ber, usado));
			moo[ber].add(new Moo(num, usado));
		}

		for (int i = 0; i < Q; i++) {
			
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			visited = new boolean[N + 1];

			int ans = dfsvbfsdfgas(K, V);
			
			bw.write(ans+"\n");;
		}
		bw.flush();
		bw.close();

	}

	private static int dfsvbfsdfgas(int k, int v) {
		int cnt = 0;
		visited[v] = true;
		Queue<ArrayList<Moo>> q = new LinkedList<>();

		q.add(moo[v]);
		while (!q.isEmpty()) {
			ArrayList<Moo> m = q.poll();
			for (Moo M : m) {
				if(!visited[M.number] && M.usado>=k) {
					q.add(moo[M.number]);
					visited[M.number] = true;
					cnt++;
				}
			}
		}
		
		return cnt;

	}

}
