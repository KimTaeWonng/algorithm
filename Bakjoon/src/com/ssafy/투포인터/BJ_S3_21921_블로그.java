package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_S3_21921_블로그 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		TreeMap<Integer, Integer> check = new TreeMap<>(Collections.reverseOrder());
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int visit = 0;
		
		for(int i=0;i<N-X+1;i++) {
			if(i==0) {
				for(int j=0;j<X;j++) {
					visit+=arr[j];
					check.put(visit, 1);
				}
			}
			else {
				visit-=arr[i-1];
				visit+=arr[i+X-1];
				
				if(check.get(visit)==null) {
					check.put(visit, 1);
				}else {
					check.put(visit, check.get(visit)+1);
				}
			}
		}
		
		if(check.firstKey()==0) {
			System.out.println("SAD");
		}else {
		System.out.println(check.firstKey());
		System.out.println(check.get(check.firstKey()));
		}

	}

}
