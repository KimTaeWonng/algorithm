package com.ssafy.gomgom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G {
	
	static double N,K,cntA,cntB,number[];
	static int count[] = new int[1001];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cntA = Math.pow(K, N);
		
		number = new double[(int)K];
		for(int i=0;i<K;i++) {
			number[i] = i+1;
		}
		
		perm(0);
		System.out.printf("%.6f",cntB/cntA);

	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			cntB+=checking();
			return;
		}
		
		for(int i=0;i<K;i++) {
			count[(int) number[i]]++;
			perm(cnt+1);
			count[(int) number[i]]--;
		}
	}

	private static double checking() {
		double K = 0;
		
		for(int i=0;i<K;i++) {
			if(count[i]>=2) {
				K+=count[i]*(count[i]-1)/2;
			}
		}
		
		return K;
	}

}
