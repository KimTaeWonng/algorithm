package com.ssafy.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			
			int check = Integer.parseInt(br.readLine());
			
			if(check==0) {
				if(plus.size()==0 && minus.size()==0) {
					bw.write("0\n");
				}else if(plus.size()==0) {
					bw.write(minus.poll()+"\n");
					
				}else if(minus.size()==0) {
					bw.write(plus.poll()+"\n");
				}else {
					if(Math.abs(minus.peek()) <= Math.abs(plus.peek()) ) {
						bw.write(minus.poll()+"\n");
					}else {
						bw.write(plus.poll()+"\n");
					}
				}
			}
			
			else {
				if(check>0) {
					plus.add(check);
				}else {
					minus.add(check);
				}
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
