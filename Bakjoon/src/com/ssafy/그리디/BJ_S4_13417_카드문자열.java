package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_13417_카드문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			
			int N = Integer.parseInt(br.readLine());	
			
			String str = br.readLine().replaceAll(" ", "");
			char[] temp = str.toCharArray();
			Deque<Character> dq = new LinkedList<Character>();
			
			for(int i=0;i<N;i++) {
				
				if(i==0) {
					dq.add(temp[i]);
				}else {
					if(dq.peekFirst() < temp[i]) {
						dq.addLast(temp[i]);
					}else {
						dq.addFirst(temp[i]);
					}
				}

			}
			
			for(int i=0;i<N;i++) {
				sb.append(dq.pollFirst());
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
