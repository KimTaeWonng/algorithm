package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1062_가르침 {

	static boolean alphabet[];
	static int N, K, max;
	static String word[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 5;

		alphabet = new boolean[26];
		word = new String[N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			str = str.substring(4, str.length()-4);
			word[i] = str;
		}
		alphabet['a' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['c' - 'a'] = true;

		if (K < 0) { // antic 도 못배움
			max = 0;
		}

		else if (K == 21) { // 다배움
			max = N;
		}

		else {
			comb(0,0);
		}
		System.out.println(max);

	}

	static void comb(int cnt, int start) {
		if (cnt == K) {
			int count = 0;
			for(int i=0;i<word.length;i++) {
				boolean check=true;
				for(int j=0;j<word[i].length();j++) {
					if(!alphabet[word[i].charAt(j)-'a']) {
						check=false;
						break;
					}
				}
				if(check) count++;
			}
			max = Math.max(max, count);
			return;
		}
		
		for(int i=start;i<alphabet.length;i++) {
			if(alphabet[i]==false) {
				alphabet[i]=true;
				comb(cnt+1,i+1);
				alphabet[i]=false;
			}
		}
	}

}
