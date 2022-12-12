package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1715_카드정렬하기 {
	
	//우선순위 큐로 맨 앞에 가장 작은수 2개를 합친다 
	//큐가 빌때까지 계속 합치면 그게 가장 작은수인데 시간복잡도는? 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		long cnt=0;
		
		//if(N==1) {
		//	cnt=0;
		//}
		
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			cnt+=a+b;
			pq.add(a+b);
		}
		
		System.out.println(cnt);

	}

}
