package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_S3_14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			hs.add(br.readLine());
		}
						
		int cnt = 0;
		
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			
			if(hs.contains(temp)) {
				cnt++;
			}
			
			
		}
		
		System.out.println(cnt);

	}

}
