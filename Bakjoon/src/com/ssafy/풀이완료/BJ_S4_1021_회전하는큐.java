package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S4_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Deque<Integer> dq = new LinkedList<Integer>();
		Deque<Integer> dq2 = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			dq.add(i+1);
			dq2.add(i+1);
		}
		int K = Integer.parseInt(st.nextToken());
		int[] target = new int[K];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<K;i++) {
			target[i]=Integer.parseInt(st.nextToken());
		}
		
		int cnt=0;
		

		
		
		for(int i=0;i<K;i++) {
			Deque<Integer> temp1 = dq;			
			//System.out.println(temp1);
			int check1=0,check2=0;
			
			while(target[i]!=temp1.peek()) {
				temp1.addFirst(temp1.pollLast());
				check1++;
			}
			
			Deque<Integer> temp2 = dq2;
			//System.out.println(temp2);
			while(target[i]!=temp2.peek()) {
				temp2.addLast(temp2.pollFirst());
				check2++;
			}
			//System.out.println(check1+" "+check2);
			cnt+= Math.min(check1, check2);
			
			//dq=temp1;
			
			dq.pollFirst();
			dq2.pollFirst();
		}
		
		System.out.println(cnt);
	}

}
