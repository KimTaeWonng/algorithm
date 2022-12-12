package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S4_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Deque<Integer> dq = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));				
				break;

			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				if(dq.size()==0) {
					System.out.println(-1);
				}else {
					System.out.println(dq.pollFirst());
				}
				break;
				
			case "pop_back":
				if(dq.size()==0) {
					System.out.println(-1);
				}else {
					System.out.println(dq.pollLast());
				}
				break;
			
			
			case "size":
				System.out.println(dq.size());
				break;
				
			case "empty":
				if(dq.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
				
			case "front":
				if(dq.size()==0) {
					System.out.println(-1);
				}else {
					System.out.println(dq.peekFirst());
				}
				break;
				
			case "back":
				if(dq.size()==0) {
					System.out.println(-1);
				}else {
					System.out.println(dq.peekLast());
				}
				break;
			}
		
				
			
		}

	}

}
