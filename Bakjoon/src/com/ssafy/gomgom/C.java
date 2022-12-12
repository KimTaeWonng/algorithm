package com.ssafy.gomgom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		char[] c = br.readLine().toCharArray();
		
		int chicken = 0;
		int food = 0;
		
		for(int i=0;i<N;i++) {
			if(c[i]=='C') {
				chicken++;
			}else {
				food++;
			}
		}
		
		System.out.println(N/(food+1));

	}

}
