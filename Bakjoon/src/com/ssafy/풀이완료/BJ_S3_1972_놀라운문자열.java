package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class BJ_S3_1972_놀라운문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while(true) {
			
			
			String str = br.readLine();			
			if(str.charAt(0)=='*') break;
			
			char[] arr = new char[str.length()];
			boolean NotSuprise = false;
			
			arr= str.toCharArray();
			
			//System.out.println(arr);
			for(int i=1;i<=arr.length-1;i++) {
				ArrayList<String> arl = new ArrayList<>();				
				for(int j=0;j<arr.length;j++) {
					StringBuilder sb = new StringBuilder();
					if(j+i>=arr.length) continue;
					sb.append(arr[j]).append(arr[j+i]);
					String temp = sb.toString();
					if(arl.contains(temp)) {
						NotSuprise = true;
					}else {
						arl.add(sb.toString());
					}
				}
				//System.out.println(arl.toString());
			}
			
			if(NotSuprise) System.out.println(str+" is NOT surprising.");
			else System.out.println(str+" is surprising.");
		}

	}

}
