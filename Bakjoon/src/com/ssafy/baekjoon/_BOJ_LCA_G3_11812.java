package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_LCA_G3_11812 {

//					1					0
//
//		  2			3 	  		4  		1  2~4
//
//		5 6 7     8 9 10     11 12 13 	2  5~13  

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {

			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(K==1) bw.write(Math.abs(a-b)+"\n"); // 1일때 시간초과남

			long parent[] = new long[2];
			int cnt=0;
			parent[0] = a;
			parent[1] = b;
			while (parent[0] != parent[1] && K!=1) {
				if (a < b) { // 다르면 더 큰 노드를 부모 위치로 올린다						
					parent[1] = (b-2) / K+1 ; 
					b = parent[1];
				} else {					
					parent[0] = (a - 2) / K + 1;
					a = parent[0];
				}
				cnt++;
			}
			
			if(K!=1)bw.write(cnt + "\n");
			

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
