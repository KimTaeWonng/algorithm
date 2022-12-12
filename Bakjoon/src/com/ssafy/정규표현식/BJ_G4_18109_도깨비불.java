package com.ssafy.정규표현식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_18109_도깨비불 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String[] str = br.readLine().split("");
		
		int cnt=0;
		for(int i=0;i<str.length-3;i++){
			String temp = str[i];
			String temp1 = str[i+1];
			String temp2 = str[i+2];
			String temp3 = str[i+3];
			
			if(temp.equals("k") || temp.equals("o") || temp.equals("i") || temp.equals("O") || temp.equals("j") || temp.equals("p") || temp.equals("u") ||temp.equals("P") ||temp.equals("y") ||temp.equals("b") ||temp.equals("l")) {
				if(temp2.equals("k") || temp2.equals("o") || temp2.equals("i") || temp2.equals("O") || temp2.equals("j") || temp2.equals("p") || temp2.equals("u") ||temp2.equals("P") ||temp2.equals("y") ||temp2.equals("b") ||temp2.equals("l") || temp2.equals("h") || temp2.equals("n") || temp2.equals("m")){
					cnt++;
					i+=2;
					continue;
				}
			}
			
			if(temp.equals("h")) {
				if(temp1.equals("k") || temp1.equals("o") || temp1.equals("l")) {
					if(temp2.equals("k") || temp2.equals("o") || temp2.equals("i") || temp2.equals("O") || temp2.equals("j") || temp2.equals("p") || temp2.equals("u") ||temp2.equals("P") ||temp2.equals("y") ||temp2.equals("b") ||temp2.equals("l") || temp2.equals("h") || temp2.equals("n") || temp2.equals("m")){
						cnt++;
						i+=2;
						continue;
					}
					
				}if(temp2.equals("k") || temp2.equals("o") || temp2.equals("i") || temp2.equals("O") || temp2.equals("j") || temp2.equals("p") || temp2.equals("u") ||temp2.equals("P") ||temp2.equals("y") ||temp2.equals("b") ||temp2.equals("l") || temp2.equals("h") || temp2.equals("n") || temp2.equals("m")){
					cnt++;
					i+=2;
					continue;
				}
			}
			
		}

	}

}
