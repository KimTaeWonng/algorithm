package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_D4_1150_백업 {
	
	//어차피 순서대로 들어가니까 i번째와 i+1번째의 거리를 계산하여 우선순위 큐에 넣자
	//그러고나서 큐에 들어가있는 거중 k개 꺼내서 더하면 그게 답?
	
	static class distance implements Comparable<distance>{
		int A;
		int B;
		int distance;
		
		
		public distance(int a, int b, int distance) {
			A = a;
			B = b;
			this.distance = distance;
		}


		@Override
		public int compareTo(distance o) {
			return this.distance-o.distance;
		}


		@Override
		public String toString() {
			return "distance [A=" + A + ", B=" + B + ", distance=" + distance + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<distance> d = new PriorityQueue<>();
		
		int arr[] = new int[N];
		boolean visit[][] = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<N-1;i++) {
			d.offer(new distance(i,i+1,arr[i+1]-arr[i]));
		}
		
		int cnt=0;
		int min=0;
		
		for(int i=0;i<K;i++) {
			cnt+=d.poll().distance;
		}
		
		System.out.println(d);

	}

}
