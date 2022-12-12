package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G2_18436_수열과쿼리37 {

	static class Segment {

		long[] tree;

		public Segment(int N) {
			tree = new long[4 * N];
		}

		public long oddInit(long[] arr, int node, int start, int end) {
			if (start == end) {
				if (arr[start] % 2 == 0) {
					return tree[node] = 0;
				} else {
					return tree[node] = 1;
				}
			} else {
				return tree[node] = oddInit(arr, node * 2, start, (start + end) / 2)
						+ oddInit(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			}
		}

		public long evenInit(long[] arr, int node, int start, int end) {
			if (start == end) {
				if (arr[start] % 2 == 0) {
					return tree[node] = 1;
				} else {
					return tree[node] = 0;
				}
			} else {
				return tree[node] = evenInit(arr, node * 2, start, (start + end) / 2)
						+ evenInit(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			}
		}

		public long odd(int node, int start, int end, int left, int right) {
			if (start > right || end < left) {
				return 0;
			} else if (start >= left && end <= right) {
				return tree[node];
			} else {
				return odd(node * 2, start, (start + end) / 2, left, right)
						+ odd(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			}
		}

		public long even(int node, int start, int end, int left, int right) {
			if (start > right || end < left) {
				return 0;
			} else if (start >= left && end <= right) {
				return tree[node];
			} else {
				return even(node * 2, start, (start + end) / 2, left, right)
						+ even(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			}
		}

		public long update(int node, int start, int end, int index, long val) {
			if (start > index || end < index) {
				return tree[node];
			} else if (start == end && start == index) {
				return tree[node] = val;
			} else {
				return tree[node] = update(node * 2, start, (start + end) / 2, index, val)
						+ update(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		long arr[] = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Segment oddSeg = new Segment(N);
		Segment evenSeg = new Segment(N);

		oddSeg.oddInit(arr, 1, 1, N);
		evenSeg.evenInit(arr, 1, 1, N);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());

			if (check == 1) {
				int index = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());
				
				if (val % 2 == 0) {
					oddSeg.update(1, 1, N, index, 0);
					evenSeg.update(1, 1, N, index, 1);
				} else {
					oddSeg.update(1, 1, N, index, 1);
					evenSeg.update(1, 1, N, index, 0);
				}
				
			} else if (check == 2) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				bw.write(evenSeg.even(1, 1, N, left, right) + "\n");
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				bw.write(oddSeg.odd(1, 1, N, left, right) + "\n");
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
