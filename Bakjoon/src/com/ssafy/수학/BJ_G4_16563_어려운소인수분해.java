package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_16563_어려운소인수분해 {
	
	static StringBuilder sb;
	static int[] primes = new int[5000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		
		primes[0] = -1;
		primes[1] = -1; // 얘네 둘은 소수가 아님
		
		for(int i=2;i<primes.length;i++) {
			primes[i] = i;
		}
		
		for(int i=2; i*i<=primes.length;i++) {
			if(primes[i] == i) {
				for(int j=i*i; j<primes.length;j+=i) {
					if(primes[j] == j) {
						primes[j] = i;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {

			int K = Integer.parseInt(st.nextToken());

			sb = new StringBuilder();

			prime(K);

			bw.write(sb + "\n");
		}

		bw.flush();

	}

	private static void prime(int k) {

		while(k>1) {
			sb.append(primes[k]+" ");
			k/=primes[k];
		}

	}

}
