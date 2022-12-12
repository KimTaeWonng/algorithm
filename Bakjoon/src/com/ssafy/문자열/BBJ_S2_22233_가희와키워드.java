package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BBJ_S2_22233_가희와키워드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hsm = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			
			hsm.put(temp, 0);
		}
		int cnt=N;
		for(int i=0;i<M;i++) {
			String[] temp = br.readLine().split(",");
			
			for(int j=0;j<temp.length;j++) {
				if(hsm.containsKey(temp[j])) {
					cnt--;
					hsm.remove(temp[j]);
				}
			}
			
			bw.write(cnt+"\n");
			
		}
		
		bw.flush();

	}

}
