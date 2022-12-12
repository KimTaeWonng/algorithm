package com.ssafy.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_1543_문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String docs = br.readLine();
		
		String word = br.readLine();
		
		int cnt=0;
		while(true) {
			if(docs.contains(word)) {
				docs = docs.replaceFirst(word, "A");
				cnt++;
			}else {
				break;
			}
		}
		
		System.out.println(cnt);

	}

}
