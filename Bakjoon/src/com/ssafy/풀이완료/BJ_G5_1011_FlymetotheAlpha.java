package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_1011_FlymetotheAlpha {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int i=1;
			int cnt=0;
			
			while(y-x>2*i) { //왼쪽에서 i씩 커지고, 오른쪽에서 i씩 작아지는 식으로 하면 계산을 절반으로 줄일 수 있다.
				x=x+i;
				y=y-i;
				cnt+=2;
				i++;
			}
			
			if(y-x>i) {   //이 기준에 충족할경우 왼쪽이나 오른쪽에서 한번만 더 움직여주면 알아서 계단형식으로 된다.
				cnt+=2;
			}else {
				cnt++;    //1 추가로 더해주는건 마지막에 Y에 도착할때 1번을 아직 계산 안했기 때문
			}
			
			System.out.println(cnt);
					
		}

	}

}
