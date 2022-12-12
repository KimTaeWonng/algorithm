package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_G5_7662_이중우선순위큐 {
	
	//우선순위큐 2개 이용해서 하나는 오름,하나는 내림차순으로 풀이  <- 시간초과
	
	//큐대신 뭐씀?

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=0;t<T;t++) {
						
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
			
			TreeMap<Integer, Integer> tr = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0;i<N;i++) {
				
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				if(str.equals("I")) {
					int a = Integer.parseInt(st.nextToken());
					tr.put(a, tr.getOrDefault(a, 0)+1);  //중복값은 value값 증가   (value의미 = 동일한 key값의 개수)								
				}
				else if(str.equals("D")) {
					if(tr.isEmpty()) continue;
					
					int a = Integer.parseInt(st.nextToken());
					if(a==1) {
						if(tr.get(tr.lastKey())==1) { //1개밖에없으면 지워
							tr.remove(tr.lastKey());
						}else {
							tr.put(tr.lastKey(), tr.get(tr.lastKey())-1); // 여러개있으면 value에서 1만큼 빼준다 = value개의 key중에서 1개를 삭제한것의 의미
						}
					}else if(a==-1) {
						if(tr.get(tr.firstKey())==1) { //1개밖에없으면 지워
							tr.remove(tr.firstKey());
						}else {
							tr.put(tr.firstKey(), tr.get(tr.firstKey())-1); // 여러개있으면 value에서 1만큼 빼준다 = value개의 key중에서 1개를 삭제한것의 의미
						}
					}
				}				
			}
			
			if(tr.size()==0) System.out.println("EMPTY");
			else System.out.println(tr.lastKey()+" "+tr.firstKey());
			
		}

	}

}
