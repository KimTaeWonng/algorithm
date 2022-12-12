package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G1_14428_수열과쿼리16 {

	static point min(point x, point y) {
		if (x.value == y.value) {
			if (x.idx < y.idx) {
				return x;
			} else {
				return y;
			}
		} else if (x.value < y.value) {
			return x;
		} else {
			return y;
		}
	}

	static class point {
		int idx;
		long value;

		public point(int idx, long value) {
			super();
			this.idx = idx;
			this.value = value;
		}

		public point(point min) {
			this.idx = min.idx;
			this.value = min.value;
		}

	}

	static class Segment {

		point[] tree;

		public Segment(int N) {
			tree = new point[N * 4];
		}

		public point init(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = new point(start, arr[start]);
			} else {
				return tree[node] = new point(min(init(arr, node * 2, start, (start + end) / 2),
						init(arr, node * 2 + 1, (start + end) / 2 + 1, end)));
			}
		}

		public point searchIdx(int node, int start, int end, int left, int right) {
			if (end < left || start > right) {
				return new point(Integer.MAX_VALUE, Long.MAX_VALUE);
			} else if (end <= right && start >= left) {
				return tree[node];
			} else {
				return min(searchIdx(node * 2, start, (start + end) / 2, left, right),
						searchIdx(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
			}
		}

		public point update(int node, int start, int end, int index, long val) {
			if (index < start || index > end) {
				return tree[node];
			} else if (start == end) {
				return tree[node] = new point(index, val);
			} else {
				return tree[node] = new point(min(update(node * 2, start, (start + end) / 2, index, val),
						update(node * 2 + 1, (start + end) / 2 + 1, end, index, val)));
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N + 1];
		arr[0] = Long.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Segment seg = new Segment(4 * N);
		seg.init(arr, 1, 1, N);
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());

			if (check == 1) {
				int index = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());

				seg.update(1, 1, N, index, val);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				bw.write(seg.searchIdx(1, 1, N, left, right).idx + "\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
