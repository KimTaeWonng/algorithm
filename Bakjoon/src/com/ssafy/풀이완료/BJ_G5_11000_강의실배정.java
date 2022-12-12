package com.ssafy.baekjoon;

import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.StringTokenizer;

public class BJ_G5_11000_강의실배정 {
	
	static class Study implements Comparable<Study>{
		int start;
		int end;
		
		public Study(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Study o) {
			if(this.start==o.start)
			return this.end-o.end;
			else return this.start-o.start;
		}

		@Override
		public String toString() {
			return "Study [start=" + start + ", end=" + end + "]";
		}
		
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Study[] sd = new Study[N];   //여기다 강의 시간들 담고
		
		PriorityQueue<Integer> end = new PriorityQueue<>();   //여기에 end 시간 담고
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			sd[i]=new Study(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(sd); 
		
		//System.out.println(Arrays.toString(sd));
		
		end.add(sd[0].end);
		
		for(int i=1;i<N;i++) {
			if(sd[i].start>=end.peek()){  //한 강의실에서 연속으로 강의할 수 있는 경우
				end.poll();  //그 강의는 강의실에 영향을 안주므로 빼버려
			}
			
			end.offer(sd[i].end); //그 다음꺼 갑니다
			
		}
		
		int cnt=0;  //강의실 개수
		
		while(!end.isEmpty()) {
			cnt++;
			end.poll();  //강의실에 영향을 줬던 것들은 아직 큐에 남아있다. 
		}
	
		

		
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
