package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_1074_Z {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = exp(N);
		int cnt = 0;
		int rr=0,cc=0;
		//System.out.println(size);
		while(size!=1) {
			size/=2;
			
			if(r<rr+size && c<cc+size) {   //r, c 둘다  중앙(size)보다 작음
				cnt+=0;
			}else if(r<rr+size && c>=cc+size)  {  // r만 중앙보다 작음
				cnt+=size*size;
				cc+=size;
			}else if(r>=rr+size && c<cc+size) {  //r만 중앙보다 큼
				cnt+=size*size*2;
				rr+=size;
			}else {                  //다 큼
				cnt+=size*size*3;
				rr+=size;
				cc+=size;
			}
		}
		
		bw.write(String.valueOf(cnt));
			
		bw.flush();	
		bw.close();
		br.close();
			
		}
	

	public static int exp(int N) {   //맵 크기
		if(N==1) {
			return 2;				
		}
		
		int y=exp(N/2);
		
		if(N%2==0) return y*y;
		
		else return y*y*2;			
	}

}
