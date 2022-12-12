package com.ssafy.정규표현식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_2671_잠수함식별 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String check = br.readLine();
		
		String temp = "^(100+1+|01)+$";
		
		if(check.matches(temp)) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}

	}

}
