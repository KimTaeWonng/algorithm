package com.ssafy.세그먼트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_ST_P4_16975 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static class Segment {

		long[] tree;

		public Segment(int N) {
			tree = new long[N * 4];
		}

		public void init(long[] arr, int node, int start, int end) { //기본 초기화
			if (start == end) {  //리프노드가 아니면 필요없다.
				tree[node] = arr[start];
			}

			else {
				init(arr, node * 2, start, (start + end) / 2);
				init(arr, node * 2 + 1, (start + end) / 2+1, end);
			}
		}

		public void update(int node, int start, int end, int left, int right, long val) {
			 if (start >= left && end <= right) { // 범위  안이면 
				tree[node] += val;
				return;
			} 		 
			
			if(left<=(start+end)/2)	update(node * 2, start, (start + end) / 2, left, right, val);  //중간값을 기준으로 왼쪽으로 가기
			if(right>(start+end)/2)	update(node * 2 + 1, (start + end) / 2 + 1, end, left, right, val); // 오른쪽으로 가기
			
		}

		public long print(int node, int start, int end, int index) {
			if (start == end) {
				return tree[node];
			} 			
			
			if(index<=(start+end)/2)	return print(node * 2, start, (start + end) / 2, index) + tree[node];   //구해야할 인덱스가 왼쪽
			else return print(node * 2 + 1, (start + end) / 2 + 1, end, index) +tree[node];	//오른쪾
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		int N = Integer.parseInt(br.readLine());
		
		long arr[] = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Segment seg;
		
		seg = new Segment(N);
		
		seg.init(arr, 1, 1, N);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			if(check==1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());
				seg.update(1, 1, N, left, right, val);
			}else {
				int index = Integer.parseInt(st.nextToken());
				bw.write(seg.print(1, 1, N, index)+"\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();

	}

}
