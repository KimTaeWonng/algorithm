package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_16360_goLatin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			
			
			StringBuilder temp = new StringBuilder(br.readLine());
			
			switch(temp.charAt(temp.length()-1)) {
			
			case 'a':
				temp.append("s");
				break;
			case 'i':
				temp.append("os");
				break;
			case 'y':
				temp.deleteCharAt(temp.length()-1);
				temp.append("ios");
				break;
			case 'l':
				temp.append("es");
				break;
			case 'n':
				temp.deleteCharAt(temp.length()-1);
				temp.append("anes");
				break;
			case 'e':
				if(temp.charAt(temp.length()-2)=='n') {
					temp.delete(temp.length()-2, temp.length());
					temp.append("anes");
				}else {
					temp.append("us");
				}
				break;
			case 'o':
				temp.append("s");
				break;
			case 'r':
				temp.append("es");
				break;
			case 't':
				temp.append("as");
				break;
			case 'u':
				temp.append("s");
				break;
			case 'v':
				temp.append("es");
				break;
			case 'w':
				temp.append("as");
				break;
			default:
				temp.append("us");
				break;
			}
			
			bw.write(temp+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
