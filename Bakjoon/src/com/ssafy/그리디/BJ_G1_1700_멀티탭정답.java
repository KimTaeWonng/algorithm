package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G1_1700_멀티탭정답 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<b; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		
		Set<Integer> set = new HashSet<>();
		
		int cnt =0;
		
		for(int i=0; i<b; i++) {
			int num = list.get(i);
			if(set.contains(num)) continue;
			if(set.size()<a) {
				set.add(num);
				continue;
			}
			
			int max = 0, idx =0;
			for(int s : set) {
				int tmp=0;
				List<Integer> sub = list.subList(i+1, b);
				if(sub.contains(s)) {
					tmp = sub.indexOf(s)+1;
				}
				else {
					tmp = b-i-1;
				}
                
				if(tmp > max) {
					max = tmp;
					idx= s;
				}
			}
			set.remove(idx);
			set.add(num);
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
