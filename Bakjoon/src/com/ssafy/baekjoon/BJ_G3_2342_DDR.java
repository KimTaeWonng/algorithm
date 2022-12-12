package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_G3_2342_DDR {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> dance = new ArrayList<>();
		
		int[] ddr = {0,0}; //초기 발 위치
		
		while(true) {
			int c = Integer.parseInt(st.nextToken());			
			if(c==0) break;			
			dance.add(c);			
		}
		
		int cnt=0;
		
		//가장 먼저 지금 넣을것이 내가 이미 밟고 있는 거라면, 그대로 밟는다.     						1st
		//그다음 0에 발이 있다면 그 발을 옮긴다.												2nd
		//지금 넣을 거 뒤에 2개가 있다면 그걸 미리보고, 
		//그게 내가 지금 1개가 밟고 있는거라면 그게 아닌 발을 옮기고, 2개면 더 가까운걸 옮긴다.				3rd
		//2개가 없다면 1개를 보고, 그게 내가 지금 밟고 있는거라면 그게 아닌 발을 옮기고, 아니면 더 가까운걸 옮긴다.	4th
		//1개도 없다면 지금 가장 가까운 발을 옮긴다.											5th
		
		for(int i=0;i<dance.size();i++) {
			if(i==0) {  //맨 첫번째 스텝
				ddr[0] = dance.get(i);
				cnt+=2;
				continue;
			}if(i==1) { //최초의 두번째 스텝
				if(ddr[0]==dance.get(i)) {
					cnt+=1;
				}else {
					ddr[1]=dance.get(i);
					cnt+=2;
				}
				continue;
			}
			if(dance.get(i)==ddr[0] || dance.get(i)==ddr[1]) {  // 1st
				cnt+=1;
				
			}else if(ddr[1]==0) {    							// 2nd
				ddr[1]=dance.get(i);
				cnt+=2;
				
			}else if(i+2 < dance.size()) {						// 3rd
				if(dance.get(i+1)==ddr[0] && dance.get(i+2)==ddr[0]) {  //뒤에 2개가 모두 첫번쨰 밟고있는 것과 동일
					ddr[1]=dance.get(i);
					if(Math.abs(ddr[1]-dance.get(i))!=2) {
						cnt+=3;
					}else {
						cnt+=4;
					}
				}else if(dance.get(i+1)==ddr[1] && dance.get(i+2)==ddr[1]) {  // 2개 모두 두번째 발과 동일
					ddr[0]=dance.get(i);
					if(Math.abs(ddr[0]-dance.get(i))!=2) {
						cnt+=3;
					}else {
						cnt+=4;
					}
				}else if((dance.get(i+1)==ddr[1] && dance.get(i+2)==ddr[0]) || (dance.get(i+1)==ddr[0] && dance.get(i+2)==ddr[1])) {  // 2개가 각각 따로 동일할 때
					if(Math.abs(ddr[0]-dance.get(i))!=2) {
						ddr[0]=dance.get(i);
						cnt+=3;
					}else {
						ddr[1]=dance.get(i);
						cnt+=3;
					}
				}else if((dance.get(i+1)==ddr[0] || dance.get(i+2)==ddr[0])) {  //1개만 동일할 때
					if(Math.abs(ddr[1]-dance.get(i))!=2) {
						ddr[1]=dance.get(i);
						cnt+=3;
					}else {
						ddr[1]=dance.get(i);
						cnt+=4;
					}
				}else if((dance.get(i+1)==ddr[1] || dance.get(i+2)==ddr[1])) {  //1개만 동일할 때
					if(Math.abs(ddr[0]-dance.get(i))!=2) {
						ddr[0]=dance.get(i);
						cnt+=3;
					}else {
						ddr[0]=dance.get(i);
						cnt+=4;
					}
				}else {   //둘다 다를땐 더 가까운걸로
					if(Math.abs(ddr[0]-dance.get(i))!=2) {
						ddr[0]=dance.get(i);
						cnt+=3;
					}else {
						ddr[1]=dance.get(i);
						cnt+=3;
					}
				}
				
			}else if(i+1 < dance.size()) {						//4th
				if(dance.get(i+1)==ddr[0]) {
					if(Math.abs(ddr[1]-dance.get(i))!=2) {
						ddr[1]=dance.get(i);
						cnt+=3;
					}else {
						ddr[1]=dance.get(i);
						cnt+=4;
					}
				}else if(dance.get(i+1)==ddr[1]) {
					if(Math.abs(ddr[0]-dance.get(i))!=2) {
						ddr[0]=dance.get(i);
						cnt+=3;
					}else {
						ddr[0]=dance.get(i);
						cnt+=4;
					}
				}else {
					if(Math.abs(ddr[0]-dance.get(i))!=2) {
						ddr[0]=dance.get(i);
						cnt+=3;
					}else {
						ddr[1]=dance.get(i);
						cnt+=3;
					}
				}				
			}else {   											//5th
				if(Math.abs(ddr[0]-dance.get(i))!=2) {
					ddr[0]=dance.get(i);
					cnt+=3;
				}else {
					ddr[1]=dance.get(i);
					cnt+=3;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
