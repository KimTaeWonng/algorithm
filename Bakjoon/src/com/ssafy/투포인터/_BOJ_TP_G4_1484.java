package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _BOJ_TP_G4_1484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int G = Integer.parseInt(br.readLine());
		
		int N = 50002;  //50001^2 - 50000^2 이 10만보다 큼
		
		ArrayList<Integer> arl = new ArrayList<>();
		
		int start=1,end=2;
		
		while(end<N) {
			
			if(Math.pow(end, 2)-Math.pow(start, 2)==G) {
				arl.add(end);
				start++;
			}else if(Math.pow(end, 2)-Math.pow(start, 2)>G) {
				start++;
			}else {
				end++;
			}
	
			
		}
		
		Collections.sort(arl);
		
		for(int i=0;i<arl.size();i++) {
			System.out.println(arl.get(i));
		}
		
		if(arl.size()==0) {
			System.out.println(-1);
		}

	}

}
