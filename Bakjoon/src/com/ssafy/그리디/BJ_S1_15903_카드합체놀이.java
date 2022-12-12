package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S1_15903_카드합체놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0;i<M;i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			pq.add(a+b);
			pq.add(a+b);
			
//			System.out.println(pq);
		}
		
		long ans = 0;
		
		for(int i=0;i<N;i++) {
			ans+=pq.poll();
		}
		
		System.out.println(ans);

	}

}
