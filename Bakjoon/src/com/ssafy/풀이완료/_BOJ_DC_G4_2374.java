package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class _BOJ_DC_G4_2374 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		long cnt=0;
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			max = Math.max(max, temp);
			if(s.size()==0) {
				s.push(temp);
				continue;
			}
			
			if(s.peek()==temp) {
				continue;
			}
			
			if(s.peek()<temp) {
				cnt+=temp-s.pop();
				s.push(temp);
			}else{
				s.pop();
				s.add(temp);
			}
			
		}
		
		
		
		
		
		while(s.size()!=0) {
			cnt += max-s.pop();
		}
		
		
		System.out.println(cnt);
		
		

	}

}
