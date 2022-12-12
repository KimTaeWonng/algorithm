package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B1_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int answer = greedy(N);

		System.out.println(answer);
	}

	static int greedy(int n) {
		boolean check = false;
		int A=0,B=0,i=1;
		
		if(n%5==0) {
			return n/5;
		}
		
		
		while (true) {
			int a = n - 3*i;
			
			if(a<0) {
				return -1;
			}			
			int b = a % 5;             
			A++;
			if (b==0) {
				return A + (a/5);
			}
			i++;			
		}					
	}
	
}


