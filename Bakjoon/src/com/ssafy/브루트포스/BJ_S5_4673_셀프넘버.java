package com.ssafy.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BJ_S5_4673_셀프넘버 {
	
	static int[] arr = new int[20000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int i=1;i<=10000;i++) {
			if(arr[i]!=0) continue;
			brute(i);
		}
		
		for(int i=1;i<=10000;i++) {
			if(arr[i]==0) {
				bw.write(i+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

	private static void brute(int cnt) {
		if(cnt>10000) {
			return;
		}

		
		int temp = cnt;
		String[] str = String.valueOf(cnt).split("");
		for(int i=0;i<str.length;i++) {
			temp +=Integer.parseInt(str[i]);
		}
		arr[temp]++;
		brute(temp);
		
	}

}
