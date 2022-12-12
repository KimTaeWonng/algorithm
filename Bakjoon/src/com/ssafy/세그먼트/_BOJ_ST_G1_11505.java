package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_ST_G1_11505 {

	static final long guguglg = 1000000007;

	static class SegmentTree {

		long tree[];

		public SegmentTree(int N) {
			tree = new long[4 * N]; // 길이 초기화
		}

		public long init(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = init(arr, node * 2, start, (start + end) / 2)
						* init(arr, node * 2 + 1, (start + end) / 2 + 1, end) %guguglg;
			}
		}

		public long multi(int node, int start, int end, int left, int right) {
			if (end < left || start > right) {
				return 1;
			}

			else if (end <= right && start >= left) {
				return tree[node];
			}

			else {
				return (multi(node * 2, start, (start + end) / 2, left, right)
						* multi(node * 2 + 1, (start + end) / 2 + 1, end, left, right)) % guguglg;
			}
		}

		public long update(int node, int start, int end, int index, long val) {
			// 1.노상관
			if (index < start || end < index) {
				return tree[node];
			} else if (start == index && end == index) {
				return tree[node] = val;
			} else {
				return tree[node] = (update(node * 2, start, (end + start) / 2, index, val)
						* update(node * 2+1, (start + end) / 2 + 1, end, index, val)) % guguglg;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N + 1];
		Arrays.fill(arr, 1);

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		SegmentTree seg = new SegmentTree(N); // 생성
		Arrays.fill(seg.tree, 1);

		seg.init(arr, 1, 1, N); // index가 1부터 시작 초기화
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			long second = Long.parseLong(st.nextToken());
			if (check == 1) {
				seg.update(1, 1, N, first, second);
			} else {
				long ans = seg.multi(1, 1, N, first, Math.toIntExact(second));

				bw.write(ans + "\n");
			}			

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
