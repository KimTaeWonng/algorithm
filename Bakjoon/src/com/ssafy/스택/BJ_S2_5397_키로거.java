package com.ssafy.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S2_5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0;n<N;n++) {
			
			Stack<String> s1 = new Stack<>();
			Stack<String> s2 = new Stack<>();
			
			String[] temp = br.readLine().split("");
			
			for(int i=0;i<temp.length;i++) {
				
				if(temp[i].equals("<")) {
					if(s1.isEmpty()) continue;
					
					s2.push(s1.pop());
				}
				
				else if(temp[i].equals(">")) {
					if(s2.isEmpty()) continue;
					
					s1.push(s2.pop());
				}
				
				else if(temp[i].equals("-")) {
					if(s1.isEmpty()) continue;
					
					s1.pop();
				}else {
					s1.push(temp[i]);
				}
				
			}
			
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			
			StringBuilder sb = new StringBuilder();
			
			while(!s1.isEmpty()) {
				sb.append(s1.pop());
			}
			bw.write(sb.reverse()+"\n");
			
		}
		
		bw.flush();

	}

}
