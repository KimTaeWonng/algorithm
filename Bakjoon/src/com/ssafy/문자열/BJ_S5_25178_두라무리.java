package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S5_25178_두라무리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean check = false;

		String temp1 = br.readLine();
		String temp2 = br.readLine();
		
		
//		if(temp1.equals(temp2)) {
//			check = true;
//		}

		if (temp1.charAt(0) != temp2.charAt(0) || temp1.charAt(N-1) != temp2.charAt(N-1)) {
			check = true;
		}
		
		if(!check) {
			char[] str1 = temp1.toCharArray();
			char[] str2 = temp2.toCharArray();
			
			Arrays.sort(str1);
			Arrays.sort(str2);
			
			for(int i=0;i<str1.length;i++) {
				if(str1[i]!=str2[i]) {
					check=true;
					break;
				}
			}
			
		}

		if (!check) {
			temp1 = temp1.replaceAll("a", "").replaceAll("e", "").replaceAll("i", "").replaceAll("o", "").replaceAll("u", "");
			temp2 = temp2.replaceAll("a", "").replaceAll("e", "").replaceAll("i", "").replaceAll("o", "").replaceAll("u", "");
			
			if(!temp1.equals(temp2)) {
				check = true;
			}
		}
		
		
		
		if(check) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}

	}

}
