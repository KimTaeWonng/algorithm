package com.ssafy.유니온파인드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_G2_4195_친구네트워크 {
	static int[] parents,cnt;
	
	static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}else {
			return parents[a] = findSet(parents[a]);
		}
	}
	
	static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) {
			return;
		}else {
			parents[bRoot] = aRoot;
			cnt[aRoot]+=cnt[bRoot];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T =Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> name = new HashMap<>(); //고유한 이름값 + 연결된 친구수
			parents = new int[N*2]; // 3줄인 경우 최대 6명까지의 이름이 등장
			cnt = new int[N*2]; //친구수
			
			int check=0;
			Arrays.fill(cnt, 1);
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				
				String first = st.nextToken();
				String second = st.nextToken();
				
				if(!name.containsKey(first)) { //첫번째 이름이 새친구이면
					parents[check]=check;
					name.put(first,check);
					check++;
				}
				
				if(!name.containsKey(second)) { //두번째 이름이 새친구이면
					parents[check]=check;
					name.put(second,check);
					check++;
				}
				
				unionSet(name.get(first), name.get(second)); //두 친구 합치기
				
				bw.write(cnt[findSet(name.get(first))]+"\n"); //친구수 출력
				
			}
			
			
			
		}
		
		bw.flush();
		br.close();
		bw.close();

	}

}
