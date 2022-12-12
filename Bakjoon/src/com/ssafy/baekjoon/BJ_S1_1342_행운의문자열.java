package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_S1_1342_행운의문자열 {

	static char[] arr;
	static int ans,alphabet[], check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		arr = br.readLine().toCharArray();
		
		

		check = new int[arr.length];
		alphabet= new int[26];
		
		for(int i=0;i<arr.length;i++) {
			alphabet[arr[i]-97]++;
		}
		

		perm(0);

		System.out.println(ans);

	}

	static void perm(int cnt) {

		if (cnt == check.length) {
			ans++;
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (alphabet[i]==0 || (cnt!=0 && check[cnt-1]==i))
				continue;

			check[cnt] = i;
			alphabet[i]--;
			perm(cnt + 1);
			alphabet[i]++;
		}
	}
	
}
