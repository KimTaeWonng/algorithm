package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.omg.CORBA.portable.ValueBase;

public class BJ_S5_15719_중복된문자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		
		temp = temp.replaceAll(" ", "");
		char[] arr = temp.toCharArray();
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=0;i<N;i++) {
			
			sum1 += Integer.parseInt(String.valueOf(arr[i]));
			sum2 += i;
			
		}
		
		System.out.println(sum1-sum2);
				
		

	}

}
