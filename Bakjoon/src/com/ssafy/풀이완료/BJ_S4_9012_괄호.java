package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=0;t<T;t++) {
			
			boolean notVPS = false;
			String text= br.readLine();
			int Left=0;
			int right=0;
			for(int i=0;i<text.length();i++) {
				if(text.charAt(i)=='(') Left++;
				else right++;
				if(Left<right) notVPS = true; 
			}
			
			if(Left==right && !notVPS) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
