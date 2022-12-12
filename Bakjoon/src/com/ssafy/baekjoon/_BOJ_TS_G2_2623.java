package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_TS_G2_2623 {
	
	public static class mubang{  //클래스 선언
		int number;  //노드번호
		int count;   //나보다 키작은 애들 수
		List<Integer> arr = new ArrayList<>();  //나보다 키큰 애들의 배열
		
		@Override
		public String toString() {
			return "mubang [number=" + number + ", count=" + count + ", arr=" + arr + "]";
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());
		
		mubang[] m = new mubang[N+1];
		
		for(int i=0;i<=N;i++) {
			m[i] = new mubang();
			m[i].number=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b,c=0;
			for(int j=0;j<a-1;j++) {				
				if(j==0) {
					b = Integer.parseInt(st.nextToken());
					c = Integer.parseInt(st.nextToken());
					m[b].arr.add(c);
					m[c].count++;
				}else {
					b = c;
					c = Integer.parseInt(st.nextToken());
					m[b].arr.add(c);
					m[c].count++;
				}
			}
		}
		
		//System.out.println(Arrays.toString(m));
		
		StringBuilder sb = new StringBuilder();
		Queue<mubang> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(m[i].count==0) {
				q.add(m[i]);
			}
		}
		
		while(!q.isEmpty()) {	//위상정렬 알고리즘
			mubang temp = q.poll();
			
			for(int i=0;i<temp.arr.size();i++) {
				int a = temp.arr.get(i);
				m[a].count--;
				if(m[a].count==0) {
					q.add(m[a]);
				}
			}
			
			sb.append(temp.number+"\n");
		}
		
		boolean isOk=true;
		
		for(int i=1;i<=N;i++) {
			if(m[i].count!=0) {
				isOk=false;
				break;
			}
		}
		
		if(isOk) bw.write(sb+"");
		else System.out.println(0);
		
		bw.flush();
		br.close();
		bw.close();

	}

}
