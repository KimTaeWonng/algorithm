package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S4_1697_숨바꼭질 {
	
	static int N,K,time[],deltas[]= {1,2,3};
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		time = new int[150001];
		
		dfs();
		
		System.out.println(ans);
		
//		System.out.println(Arrays.toString(time));

	}

	private static void dfs() {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		
		time[N] = 1;
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp==K) {
				ans = time[temp]-1;
			}
			
			if(isin(temp*2) && time[temp*2]==0) {
				time[temp*2] = time[temp];
				q.add(temp*2);
			}
			
			if(isin(temp-1) && time[temp-1]==0) {
				time[temp-1] = time[temp]+1;
				q.add(temp-1);
			}
			if(isin(temp+1) && time[temp+1]==0) {
				time[temp+1] = time[temp]+1;
				q.add(temp+1);
			}
			
		}
	}
	
	static boolean isin(int N) {
		return N>=0 && N<150001;
	}

}
