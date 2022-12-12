package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_G4_1083_소트 {

//	큰 수가 앞에도록 정렬함

//	모든 수에 대해
//	arr[i]>arr[i+1] 이면;
//	남은 교환은 계속 맨뒤에 수만 바꿔줌
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arl = new ArrayList<>(); 
		
		for(int i=0;i<N;i++) {
			int k = Integer.parseInt(st.nextToken()); 
			arl.add(k);
		}
		
		
		int S = Integer.parseInt(br.readLine());   //여기까지 입력값 넣기
		 
		
		int moveCnt=0,cnt = 0;
		int k=0;    
		int max =0;
		int nowLocate=0;    
		while(moveCnt!=S && nowLocate!=N-1) {  //횟수 다 썼으면 or 남았는데 정렬 필요없으면 나와그냥
			max = arl.get(nowLocate);
			int maxLocate= -999;   
			k= nowLocate+1; cnt=1;
			while(true) {
				if(moveCnt + cnt > S || k>=N) {  //S보다 더 많이 움직이거나, 현재 위치가 N보다 크면
					break;
				}
				int temp = arl.get(k);
				if(temp>max) {   //그 안에서 젤 큰값 찾기
					max = temp;
					maxLocate=k; //젤 큰놈이 지금 있는 위치
				}
				cnt++;
				k++;
			}
			
			if(maxLocate!=-999) { //-999가 아니면 = 수를 바꿔줄 필요가 있으면
				arl.remove(maxLocate);  //최고값을 지우고
				arl.add(nowLocate,max); // 처음 정한 자리에 그 최고값을 넣으면 그 뒷수는 쭉 밀려요
				moveCnt += maxLocate-nowLocate; //얘를 옮기는데 필요했던 거리 = 교환횟수
			}
			nowLocate++;
		}
		
		
		
		for(int i=0;i<N;i++) {
			System.out.print(arl.get(i)+" ");
		}
		
		

	}

}
