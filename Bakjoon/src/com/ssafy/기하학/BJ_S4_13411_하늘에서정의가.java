package com.ssafy.기하학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S4_13411_하늘에서정의가 {
	
	static class enemy implements Comparable<enemy>{
		int number;
		double time;
		
		
		public enemy(int number, double time) {
			super();
			this.number = number;
			this.time = time;
		}
		

		@Override
		public int compareTo(enemy o) {  //정렬기준 
			// TODO Auto-generated method stub
			return Double.compare(this.time, o.time);
		}
		
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		enemy[] E = new enemy[N]; 
				
		
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			
			double time = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)) / speed;  // 격추되는 시간
			E[i] = new enemy(i+1, time);
		}
		
		Arrays.sort(E);
		
		for(int i=0;i<N;i++) {
			bw.write(E[i].number+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
