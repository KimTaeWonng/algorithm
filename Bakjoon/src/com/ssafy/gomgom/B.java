package com.ssafy.gomgom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashSet<String> hs = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			
			if(str.equals("ENTER")) {
				cnt+=hs.size();
				hs.clear();
			}else {
				hs.add(str);
			}
		}
		
		cnt+=hs.size();
		
		System.out.println(cnt);

	}

}
