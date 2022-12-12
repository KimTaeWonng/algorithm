package com.ssafy.정규표현식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_5637_가장긴단어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int max=0;
		String temp = " ";
		String regex = "[^a-z-]";
		boolean check= false;
		while(true) {
			String[] str = br.readLine().toLowerCase().split(regex);
			
			for(int i=0;i<str.length;i++) {
				if(str[i].equals("e-n-d")) {
					check = true;
				}else {
					if(max<str[i].length()) {
						max = str[i].length();
						temp = str[i];
					}
				}
			}
		
			
			if(check) {
				break;
			}
	
		}
		
		System.out.println(temp);

	}

}
