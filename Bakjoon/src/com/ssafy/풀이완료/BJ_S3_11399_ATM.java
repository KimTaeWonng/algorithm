package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class BJ_S3_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		int time=0;
		int timeArr[] = new int[N]; 
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int K=Integer.parseInt(st.nextToken());
			pq.add(K);
		}
		//System.out.println(pq);
		
		for(int i=0;i<N;i++) {
			time = pq.poll();
			timeArr[i] = time;
		}
		
		
		
		//System.out.println(Arrays.toString(timeArr));
		time=0;
		int answer=0;
		
		for(int i=0;i<N;i++) {
			time+=timeArr[i];
			answer+=time;
		}
		
		System.out.println(answer);

	}

}
