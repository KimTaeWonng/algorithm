package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G1_16134_조합 {
	
	static long[] memo;
	static int mod = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());			
			int R = Integer.parseInt(st.nextToken());
			
			memo = new long[N+1];
			factorial(N);
			
			//System.out.println(Arrays.toString(memo));
			
			
			long ans = (memo[N] * power(memo[R],mod-2) % mod * power(memo[N-R],mod-2)%mod )%mod;
			
			System.out.println(ans);
		

	}
	
	public static void factorial(int n) {
		
		memo[0]=1;
		
		for(int i=1;i<=n;i++) {
			
			memo[i] = memo[i-1]*i;
			
			if(memo[i]>mod) {
				memo[i]%=mod;
			}	
		}

	}
	
	static long power(long l, long p) {
		
		long res = 1;
		
		l = l % p;
		while(p>0) {
			if(p % 2==1) {
				res = (res*l)% mod;
			}
			p = p >> 1;
			l = (l*l)% mod;
		}
		
		return res;
	}

}
