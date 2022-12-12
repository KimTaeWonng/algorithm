package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_4949_균형잡힌세상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			sb = new StringBuilder();
			sb.append(br.readLine());
			Stack<Character> s = new Stack<>();
			
			if(sb.length()==1 && sb.charAt(0)=='.') break;
	
			boolean notVPS = false;
			
			for(int i=0;i<sb.length();i++) {
				if(sb.charAt(i)=='(' || sb.charAt(i)=='[') {
					s.push(sb.charAt(i));
				}
				if(sb.charAt(i)==')') {
					if(s.size()==0) {
						notVPS = true;
						break;
					}
					char c = s.pop();
					if(c!='(') {
						notVPS = true;
						break;
					}
				}
				if(sb.charAt(i)==']') {
					if(s.size()==0) {
						notVPS = true;
						break;
					}
					char c = s.pop();
					if(c!='[') {
						notVPS = true;
						break;
					}
				}
			}
			if(!s.isEmpty()) notVPS = true;
			
			if(!notVPS) System.out.println("yes");
			else System.out.println("no");
		}
		

	}

}
