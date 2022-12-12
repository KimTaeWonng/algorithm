package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S3_2346_풍선 {
	
	static class Ballon{
		int index;
		int number;
		
		public Ballon(int index, int number) {
			super();
			this.index = index;
			this.number = number;
		}

		@Override
		public String toString() {
			return "Ballon [index=" + index + ", number=" + number + "]";
		}
		
		
				
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Ballon> ballon = new ArrayDeque<>();  //LinkedList는 메모리 초과걸림
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			ballon.add(new Ballon(i+1,Integer.parseInt(st.nextToken())));
		}


		while(ballon.size()>1) {			
				Ballon temp = ballon.poll();
				sb.append(temp.index).append(" ");
				int go = temp.number;
				
				if(go>0) {					
					for(int i=0;i<go-1;i++) {
						ballon.addLast(ballon.pollFirst());		   	//풍선 안의 숫자가 양수면 				
					}
				}else {
					for(int i=0;i<Math.abs(go);i++) {
						ballon.addFirst(ballon.pollLast());			// 음수면				
					}
				}
				
			
		}
			//System.out.println(ballon); //왜 하나가 남지
			
		sb.append(ballon.poll().index);
		bw.write(sb+"");
		
		
		bw.flush();
		bw.close();
		br.close();
		
		
		

	}

}
