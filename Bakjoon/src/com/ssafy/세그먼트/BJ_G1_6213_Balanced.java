package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G1_6213_Balanced {
	
	static class SegmentTree {

		long[] tree;

		public SegmentTree(int N) {
			tree = new long[4 * N];
		}

		public long minInit(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = Math.min(minInit(arr, node * 2, start, (end + start) / 2),
						minInit(arr, node * 2 + 1, (start + end)/2 + 1, end));
			}
		}

		public long maxInit(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			} else {
				return tree[node] = Math.max(maxInit(arr, node * 2, start, (start + end) / 2),
						maxInit(arr, node * 2 + 1, (start + end)/2 + 1, end));
			}
		}

		public long checkMin(int node, int start, int end, int left, int right) {
			if (end < left || start > right) {
				return 1000000001;
			} else if (end <= right && start >= left) {
				return tree[node];
			} else {
				return Math.min(checkMin(node * 2, start, (end + start) / 2, left, right),
						checkMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
			}
		}

		public long checkMax(int node, int start, int end, int left, int right) {
			if (end < left || start > right) {
				return -1;
			} else if (end <= right && start >= left) {
				return tree[node];
			} else {
				return Math.max(checkMax(node * 2, start, (end + start) / 2, left, right),
						checkMax(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
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
		
		long[] arr = new long[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree minS = new SegmentTree(N);
		SegmentTree maxS = new SegmentTree(N);
		
		minS.minInit(arr, 1, 1, N);
		maxS.maxInit(arr, 1, 1, N);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			long min = minS.checkMin(1, 1, N, left, right);
			long max = maxS.checkMax(1, 1, N, left, right);
			
			bw.write(max-min+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		

	}

}
