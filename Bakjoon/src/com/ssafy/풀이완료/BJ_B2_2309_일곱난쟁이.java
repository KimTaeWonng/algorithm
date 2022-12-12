package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_2309_일곱난쟁이 {
	
	static int input[],nanjang[];
	static boolean ok;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		input = new int[9];
		nanjang = new int[7];
		
		for(int i=0;i<9;i++) {
			input[i]=Integer.parseInt(br.readLine());
		}
		
		comb(0,0);		

	}
	
	static void comb(int cnt,int start) {
		if(cnt==7) {
			int answer=0;
			for(int i=0;i<7;i++) {
				answer+=nanjang[i];
			}
			if(answer==100 && !ok) {
				ok=true;
				Arrays.sort(nanjang);
				for(int i=0;i<7;i++) {
					System.out.println(nanjang[i]);
				}
			}
			return;
		}
		
		
		for(int i=start;i<9;i++) {
			nanjang[cnt]=input[i];
			comb(cnt+1,i+1);
		}
	}

}
