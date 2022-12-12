package com.ssafy.기하학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_10655_마라톤1 {
	static class checkPoint{
		int x;
		int y;
		int D;
		
		
		
		public checkPoint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}



		public checkPoint(int x, int y, int D) {
			super();
			this.x = x;
			this.y = y;
			this.D = D;

		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		checkPoint[] cp = new checkPoint[N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			cp[i] = new checkPoint(x, y, 0);
		}
		
		int min=Integer.MAX_VALUE;
		int ans = 0;
		
		for(int i=1;i<N;i++) {
//			System.out.println(cp[i].x+" "+cp[i].y);
			ans+= Math.abs(cp[i].x-cp[i-1].x) + Math.abs(cp[i].y-cp[i-1].y); // 총 길이
		}
		
		for(int i=1;i<N-1;i++) {
			int FrontD = Math.abs(cp[i].x-cp[i-1].x) + Math.abs(cp[i].y-cp[i-1].y);
			int BackD = Math.abs(cp[i].x-cp[i+1].x) + Math.abs(cp[i].y-cp[i+1].y);
			cp[i].D = FrontD + BackD;
			int temp = ans;
			temp-= cp[i].D;
			temp+= Math.abs(cp[i-1].x-cp[i+1].x) + Math.abs(cp[i-1].y-cp[i+1].y);
			
			if(min>temp) {
				min = temp;
			}
		}
		
		

		
		
		
		System.out.println(min);
		
		
	}

}
