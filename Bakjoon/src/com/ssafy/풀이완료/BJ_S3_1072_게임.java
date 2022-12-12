package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_1072_게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		double Y = Integer.parseInt(st.nextToken());
		
		double X = Integer.parseInt(st.nextToken());
		
		long Z = (int)(100*X/Y);
		long cnt=0;
		while(true) {
			if(Z>=99) {
				cnt=-1;
				break;
			}
			X+=1;
			Y+=1;
			long temp = (int)(100*X/Y);
			cnt++;
			if(Z!=temp) {
				break;
			}
		}
		
		System.out.println(cnt);

	}

}
