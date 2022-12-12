package com.ssafy.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G3_18429_근손실 {
	
	static int arr[],N,K,ans;
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		checked = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs(0,500);
		
		System.out.println(ans);
		

	}
	
	static void bfs(int cnt,int power) {
		if(power<500) {
			return;
		}
		if(cnt==N) {
			ans++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!checked[i]) {
				checked[i] = true;
				power+=arr[i];
				power-=K;
				bfs(cnt+1,power);
				checked[i]=false;
				power-=arr[i];
				power+=K;
			}
		}
	}

}
