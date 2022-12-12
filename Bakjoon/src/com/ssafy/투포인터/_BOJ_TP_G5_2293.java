package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_TP_G5_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[N+1];
		int memo[] = new int[K+1];
		memo[0]=1;
		
		for(int i=1;i<=N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		//여기까지 입력
		
		Arrays.sort(coin);
		
		for(int i=1;i<=N;i++) {
			for(int j=coin[i];j<=K;j++) {
				memo[j] = memo[j]+memo[j-coin[i]];
			}
		}
		
		System.out.println(memo[K]);

	}

}
