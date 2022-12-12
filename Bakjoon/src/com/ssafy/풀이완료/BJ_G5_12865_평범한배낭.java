package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_12865_평범한배낭 {
	
	static class goods{
		int weight;
		int values;
		
		public goods(int weight, int values) {
			super();
			this.weight = weight;
			this.values = values;
		}
		
		
	}
	
	static int N,K,memo[][];
	static goods g[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		memo = new int[N+1][K+1];
		
		g = new goods[N+1];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				memo[i][j]=-1;
			}
		}
		for(int i=0;i<=N;i++) {
			memo[i][0]=0;
		}
		for(int i=0;i<=K;i++) {
			memo[0][i]=0;
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			g[i] = new goods(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		////입력 받기 및 초기화
		
		System.out.println(dp());

	}
	
	static int dp() {
		
		
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=K;j++) {
					if(g[i].weight>j) {
						memo[i][j] = memo[i-1][j]; //어차피 못넣으니까 이전꺼 가져옴
					}else {
						memo[i][j] = Math.max(g[i].values+memo[i-1][j-g[i].weight], memo[i-1][j]);  //넣는것과 안넣는것 중 최적해 비교
					}
				}
			}
		
		
		
		return memo[N][K];
	}

}
