package com.ssafy.기하학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S3_1485_정사각형 {
	
	static class point{
		int x;
		int y;
		
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			boolean NOT = false;
			ArrayList<Double> arr = new ArrayList<>();
			
			point[] p = new point[4];
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				p[i] = new point(x,y);
			}
			
			for(int i=0;i<4;i++) {
				
				for(int j=0;j<4;j++) {
					if(i==j) continue;
					
					arr.add(dist(p[i].x,p[i].y,p[j].x,p[j].y));
					
				}
			}
			
			Collections.sort(arr);
			
			double temp = arr.get(0);
			for(int i=1;i<8;i++) {
				if(temp!=arr.get(i)) {
					NOT=true;
					break;
				}
			}
			temp = arr.get(8);
			for(int i=9;i<arr.size();i++) {
				if(temp!=Math.sqrt(Math.pow(arr.get(0),2)) && temp!=arr.get(i)){
					NOT=true;
					break;
				}
			}
			
			if(NOT) {
				bw.write("0\n");
			}else {
				bw.write("1\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static double dist(int x1, int y1,int x2,int y2) {
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2));
	}

}
