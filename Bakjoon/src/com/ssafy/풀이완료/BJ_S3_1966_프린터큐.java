package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			Queue<Integer> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				q.offer(temp);
				pq.offer(temp);
			}
			
			

			int cnt=0;
			while (true) {
				//타겟이 맨앞에 왔을 때
				if (target == 0) {
					//System.out.println(q.peek()+" 0 "+pq.peek());
					if (q.peek() == pq.peek()) {
						cnt++;
						break;
					}else {
						int temp = q.poll();
						q.offer(temp);
						target=q.size()-1;
					}
				}else {
				//타겟이 맨앞이 아닐 때
					//System.out.println(q.peek()+" - "+pq.peek());
					if(q.peek()==pq.peek()) {
						cnt++;
						target--;
						q.poll();
						pq.poll();
					}else {						
						target--;
						int temp=q.poll();
						q.offer(temp);
					}
				}
				
			}
			
			System.out.println(cnt);

		}

	}

}
