package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S4_11866_요세푸스0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		Queue<Integer> answer = new LinkedList<>();
		
		while(!q.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				int temp = q.poll();
				q.offer(temp);
			}
			answer.offer(q.poll());
		}
		
		System.out.print("<"+answer.poll());
		int I = answer.size();
		for(int i=0;i<I;i++) {
			System.out.print(", "+answer.poll());
		}
		System.out.print(">");
		

	}

}
