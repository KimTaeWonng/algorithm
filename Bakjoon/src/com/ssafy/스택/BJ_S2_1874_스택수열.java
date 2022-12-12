package com.ssafy.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S2_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int max = 0;
		boolean check= false;
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;
			if(temp>max) {
				max = temp;
			}
		}
		
		int cnt=1;
		int now=1;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			while(cnt<=arr[i]) {
				sb.append("+\n");
				s.push(cnt++);
				now=s.peek();
			}
			
			if(now==arr[i]) {
				s.pop();
				sb.append("-\n");
				if(s.size()!=0) {
					now=s.peek();
				}
			}else {
			
			while(now!=arr[i]) {
				
				s.pop();
				if(s.size()==0) {
					check=true;
					break;
				}
				now=s.peek();
				sb.append("-\n");
				
			}
			}
			
			if(check) {
				break;
			}
		}
		
		if(check) {
			System.out.println("NO");
		}else {
			System.out.println(sb);
		}

	}

}
