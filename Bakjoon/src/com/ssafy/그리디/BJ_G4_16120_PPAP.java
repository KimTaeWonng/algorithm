package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_16120_PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String PPAP = br.readLine();
		boolean check = false;
		int hasP = 0;
		
		for(int i=0;i<PPAP.length();i++) {
			if(PPAP.charAt(i)=='P') {
				hasP++;
			}
			if(PPAP.charAt(i)=='A') {
				if(hasP>=2 && i<PPAP.length()-1 && PPAP.charAt(i+1)=='P') {
					hasP--; // PPAP -> P 로 바뀌므로 갖고있던 P를 하나 줄여줌 ( PP->P)
					i++;
				}else {
					check=true;
					break;
				}
			}
		}
		
		
		
		if(check || hasP>=2) System.out.println("NP"); //A가 이상한데 있거나, PP... 이렇게 남아있는 경우
		else System.out.println("PPAP");

	}

}
