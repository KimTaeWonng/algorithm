package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int dist[] = new int[N-1];
		int city[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		long cost = Integer.MAX_VALUE;
		long ans = 0;
		
		for(int i=0;i<N-1;i++) {
			if(cost > city[i]) {
				cost = city[i];
			}
			ans += cost*dist[i];
		}
		
		System.out.println(ans);


	}

}
