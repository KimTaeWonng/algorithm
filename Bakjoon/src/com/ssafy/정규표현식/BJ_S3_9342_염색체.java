package com.ssafy.정규표현식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_9342_염색체 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String regex = "^[A-F]?A+F+C+[A-F]?$";
		
		int N = Integer.parseInt(br.readLine());

		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			
			if(temp.matches(regex)) {
				System.out.println("Infected!");
			}else {
				System.out.println("Good");
			}
		}
	}

}
