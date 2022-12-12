package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_16953_AB {
	static int A,B,cnt,answer;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		run(A,B);
		
		if(check) System.out.println(-1);
		else System.out.println(answer+1);

	}
	
	static void run(int A,int B) {
		while(B!=A) {
			if(B%2==1 && B%10!=1) {
				check=true;
				break;
			}
			
			if(B%10==1) {
				B=B/10;
			}else {
				B/=2;
			}
			
			if(B<A) {
				check=true;
				break;
			}
			
			answer++;
				
		}
	}

}
