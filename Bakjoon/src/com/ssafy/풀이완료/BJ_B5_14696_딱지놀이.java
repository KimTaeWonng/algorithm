package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B5_14696_딱지놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			
			int[] a = new int[5];  //1~4까지 배열 저장할거
			int[] b = new int[5];
			
			st= new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			for(int i=0;i<A;i++) {
				a[Integer.parseInt(st.nextToken())]++;
			}
			
			st= new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			for(int i=0;i<B;i++) {
				b[Integer.parseInt(st.nextToken())]++;
			}
			
			boolean WinA = false, WinB = false, draw = true;
			
			for(int i=4;i>=1;i--) {
				if(a[i]>b[i]) {
					draw = false;
					WinA = true;
					break;
				}else if(a[i]<b[i]) {
					draw = false;
					WinB = true;
					break;
				}
			}
			
			if(WinA) System.out.println("A");
			if(WinB) System.out.println("B");
			if(draw) System.out.println("D");
			
			
		}

	}

}
