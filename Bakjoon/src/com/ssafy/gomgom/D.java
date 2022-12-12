package com.ssafy.gomgom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		boolean isYes=false;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cnt+= Integer.parseInt(st.nextToken());
			
			if(cnt%7==4) {
				isYes=true;
				break;
			}
		}
		
		if(isYes) System.out.println("YES");
		else System.out.println("NO");

	}

}
