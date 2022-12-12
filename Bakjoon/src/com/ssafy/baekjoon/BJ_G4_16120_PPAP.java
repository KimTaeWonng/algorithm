package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G4_16120_PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		char[] ch = br.readLine().toCharArray();
		Stack<Character> ppap = new Stack<>();
		Stack<Character> papp = new Stack<>();
		
		for(int i=ch.length-1;i>=0;i--) {
			ppap.push(ch[i]);
		}
		
//		System.out.println(ppap);
		boolean isPPAP = false;
		
		if(ppap.size()==1 && ppap.peek()=='P') {
			isPPAP=true;
		}
		
		while(ppap.size()>=4) {
			papp.push(ppap.pop());
			
			if(papp.peek()=='P') {
				for(int i=0;i<3;i++) {
					papp.push(ppap.pop());
				}
				char a = papp.pop();  //p
				char b = papp.pop();  //a
				char c = papp.pop();  //p
				if(a=='P' && b=='A' && c=='P') {
					isPPAP = true;
				}else {
					ppap.push(a);
					ppap.push(b);
					ppap.push(c);
				}
			}
			
			if(isPPAP) break;
		}
		System.out.println(ppap);
		if(isPPAP) System.out.println("PPAP");
		else System.out.println("NP");

	}

}
