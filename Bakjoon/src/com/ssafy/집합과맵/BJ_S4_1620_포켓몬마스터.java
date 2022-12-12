package com.ssafy.집합과맵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_S4_1620_포켓몬마스터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashMap<Integer,String> hmi = new HashMap<>();
		HashMap<String,Integer> hms = new HashMap<>();
		st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		
		for(int i=1;i<=n;i++) {
			String pokemon = br.readLine();
			hmi.put(i, pokemon);		
			hms.put(pokemon, i);
		}
		
		for(int i=0;i<m;i++) {
			String temp = br.readLine();
			//System.out.println(temp);
			if(temp.matches("[0-9]+")) {
				bw.write(hmi.get(Integer.parseInt(temp))+"\n");
			}else {
				bw.write(hms.get(temp)+"\n");
			}
		}
		
		bw.flush();
		
		
		

	}

}
