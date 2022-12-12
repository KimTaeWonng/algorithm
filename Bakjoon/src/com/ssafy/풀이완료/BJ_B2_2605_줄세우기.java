package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_B2_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N= Integer.parseInt(br.readLine());
		Stack<Integer> line = new Stack<>();
		Stack<Integer> num = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int number = Integer.parseInt(st.nextToken());
			for(int n=0;n<number;n++) {
				num.push(line.pop());
			}
			line.push(i);
			for(int n=0;n<number;n++) {
				line.push(num.pop());
			}
		}
		
		while(!line.isEmpty()) {
			num.push(line.pop());
		}
		
		while(!num.isEmpty()) {
			System.out.print(num.pop()+" ");
		}
		

	}

}
