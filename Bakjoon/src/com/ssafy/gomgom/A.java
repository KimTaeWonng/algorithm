package com.ssafy.gomgom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int chicken = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int coke = Integer.parseInt(st.nextToken());
		int beer = Integer.parseInt(st.nextToken());
		int cnt=0;
		while(chicken!=0) {
			
			if(coke>=2) {
				coke-=2;
			}else if(beer>=1){
				beer--;
			}else {
				break;
			}
			
			chicken--;
			cnt++;		
		}
		
		System.out.println(cnt);

	}

}
