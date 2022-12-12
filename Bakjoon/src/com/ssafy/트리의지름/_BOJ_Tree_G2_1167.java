package com.ssafy.트리의지름;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _BOJ_Tree_G2_1167 {

	static class Node {
		int number;
		int val;

		public Node(int number, int val) {
			super();
			this.number = number;
			this.val = val;
		}
	}

	static int N, max, maxidx;
	static ArrayList<Node> node[];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		node = new ArrayList[N + 1];

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			node[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken()); // 연결트리노드 1

			while (true) {
				int second = Integer.parseInt(st.nextToken()); // 연결트리노드 2

				if (second == -1) {
					break;
				}

				int third = Integer.parseInt(st.nextToken()); // 가중치

				node[first].add(new Node(second, third));
				node[second].add(new Node(first, third)); // 양방향 트리
			}

		}

		visited[1] = true;
		dfs(1, 0); // 루트노드에서 한번 돌림

		visited = new boolean[N + 1]; // 한번 더 해야대니까 초기화
		visited[maxidx] = true; // 처음 돌릴때 가장 먼거리였던 노드 부터 시작
		dfs(maxidx, 0);
		System.out.println(max);
	}

	static void dfs(int num, int val) {

		if (max < val) {
			max = val;
			maxidx = num;
		}

		for (Node temp : node[num]) {
			if (!visited[temp.number]) {
				visited[temp.number] = true;
				dfs(temp.number, val + temp.val);
			}
		}
	}

}
