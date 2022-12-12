package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S4_1026_보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		//B는 재 배열하면 안된다고 써있지만 걍 해도됨
		PriorityQueue<Integer> A = new PriorityQueue<>();      //얘는 작아지는 순으로
		PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());  //얘는 커지는 순으로
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			cnt+= A.poll()*B.poll();   //B의 가장 큰수에 A의 가장 작은수가 곱해진다.  = 최소값이 된다.
		}
		
		System.out.println(cnt);

	}

}
