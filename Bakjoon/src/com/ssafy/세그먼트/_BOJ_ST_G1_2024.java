package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_ST_G1_2024 {

	static class Segment {
		long[] tree;

		public Segment(int N) { // 생성
			double treeHeight = Math.ceil(Math.log(N) / Math.log(2)) + 1; // 트리의 높이
			long treeNodeCount = Math.round(Math.pow(2, treeHeight)); // 트리의 노드개수
			tree = new long[Math.toIntExact(treeNodeCount)]; // 트리의 길이
		}

		public long init(long[] arr, int node, int start, int end) { // 초기화
			if (start == end) {
				return tree[node] = arr[start]; // 리프노드일때
			} else {
				return tree[node] = init(arr, node * 2, start, (start + end) / 2)
						+ init(arr, node * 2 + 1, (start + end) / 2 + 1, end); // 아니면 재귀
			}

		}

		public long sum(int node, int start, int end, int left, int right) { // 구간 합 구하기
			// 1. 노드와 구할 구간이 전혀 상관없으면 그냥 리턴
			if (end < left || start > right) {
				return 0;
			}
			// 2.  구할 구간의 안쪽에 노드가 있거나 완전 같은경우 (전부 다 더해줘도 됨 == 트리의 해당 노드의 값)
			else if (end <= right && start >= left) {
				return tree[node];
			}
			// 3. 이외에 반만 걸치거나, 노드의 안쪽에  구할 구간이 있는 경우 (자식노드를 탐색하기 위해 더 깊숙히 이동)
			else {
				return sum(node * 2, start, (end + start) / 2, left, right)
						+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			}

		}

		public long update(int node, int start, int end, int index, long val) { // 바꿀 값을 직접 변경 후 부모노드 수정
			// 1. 상관없는 부분
			if (index < start || end < index) {
				return tree[node]; // 값 변경할 필요없이 그대로 출력
			}
			// 2. 완전 동일한 부분(해당 리프노드)
			else if (start == index && end == index) {
				return tree[node] = val;
			}
			// 3. 이외에 변경될 해당 노드를 포함하고 있는 부분(해당 리프노드의 부모노드들)
			else {
				return tree[node] = update(node * 2, start, (end + start) / 2, index, val)
						+ update(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		// 여기까지 값 입력

		Segment seg = new Segment(N); // 생성

		seg.init(arr, 1, 1, N); // index가 1부터 시작 초기화
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			long second = Long.parseLong(st.nextToken());
			if (check == 1) {
				seg.update(1, 1, N, first, second);
			} else {
				long ans = seg.sum(1, 1, N, first, Math.toIntExact(second));

				bw.write(ans + "\n");
			}

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
