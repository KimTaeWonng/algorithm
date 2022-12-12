package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_G5_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			char[] ch =br.readLine().toCharArray();
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(),"[],");
			Deque<Integer> dq = new ArrayDeque<>();
			
			while(st.hasMoreTokens()){ 
				dq.add(Integer.parseInt(st.nextToken()));
			}			
			
			
			
			boolean error=false;
			boolean first=true;
			
			for(int i=0;i<ch.length;i++) {
				if(error) break;
				switch(ch[i]) {
				case 'R':
					if(first) {
						first=false;
					}else {
						first=true;
					}
					break;
				case 'D':
					if(dq.isEmpty()) {
						error=true;
						break;
					}
					if(first) {
						dq.pollFirst();
					}else {
						dq.pollLast();
					}				
				}
			}
			
			if(error) System.out.println("error");
			else {
				bw.write("[");
				if(first && !dq.isEmpty()) {
					int a = dq.size();
					for(int i=0;i<a-1;i++) {
						bw.write(dq.pollFirst()+",");
					}
					
				}else if(!first && !dq.isEmpty()) {
					int a =dq.size();
					for(int i=0;i<a-1;i++) {
						bw.write(dq.pollLast()+",");
					}
				}
				if(!dq.isEmpty()) 				
				bw.write(dq.poll()+"");
				bw.write("]\n");
				
			}
			bw.flush();
		}
				
		bw.close();
		br.close();

	}

}
