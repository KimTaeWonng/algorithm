package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G1_1275_커피숍2 {
	
	static class Segment{
		
		long[] tree;
		
		public Segment(int N) {
			tree = new long[4*N];
		}
		
		public long init(long[] arr, int node, int start,int end) {
			if(start==end) {
				return tree[node] = arr[start];
			}
			else {
				return tree[node] = init(arr,node*2,start,(start+end)/2) + init(arr, node*2+1, (start+end)/2+1 , end);
			}
		}
		
		public long sum(int node, int start, int end, int left, int right) {
			if(start>right || end< left) {
				return 0;
			}else if(start>=left && end<=right) {
				return tree[node];
			}else {
				return sum(node*2, start, (start+end)/2 , left, right) + sum(node*2+1, (start+end )/2+1, end, left, right);
			}
		}
		
		public long update(int node, int start , int end , int index , long val) {
			if(start>index || end<index) {
				return tree[node];
			}else if(start==end && start==index) {
				return tree[node] = val;
			}else {
				return tree[node] = update(node*2, start, (start+end )/2, index, val) + update(node*2+1, (start+end)/2+1 , end, index, val);
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
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Segment seg = new Segment(N);
		
		seg.init(arr, 1, 1, N);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			long val = Long.parseLong(st.nextToken());
			
			if(left<right) {
			bw.write(seg.sum(1, 1, N, left, right)+"\n");
			}else {
				bw.write(seg.sum(1, 1, N, right, left)+"\n");
			}
			seg.update(1, 1, N, index, val);
		}
		
		bw.flush();
		br.close();
		bw.close();

	}

}
