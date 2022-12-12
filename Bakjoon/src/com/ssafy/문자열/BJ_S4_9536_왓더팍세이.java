package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_9536_왓더팍세이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			String[] voice = br.readLine().split(" ");
			
			while(true) {
				
				st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				if(st.nextToken().equals("goes")) {
					String temp = st.nextToken();
					for(int i=0;i<voice.length;i++) {
						if(voice[i].equals(temp)) {
							voice[i]="";
						}
					}
				}
				
				else{
					break;
				}
			}
			
			for(int i=0;i<voice.length;i++) {
				if(!voice[i].equals("")) {
					bw.write(voice[i]+" ");
				}
			}
			
			bw.write("\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
