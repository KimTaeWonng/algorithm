package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_P5_2923_숫자게임 {

	// 두 동적 배열을 만들어서 하나는 큰순, 하나는 작은순으로 정렬시킨다.
	// 그 후 각 자리에 맞는 수를 더해서 그 수가 MAX인 값을 찾아내어라. -->시간초과

	// 두 카운터배열을 만들어서 각각의 수를 체크하고
	// 그 후 하나는 작은순, 하나는 큰순으로 각각을 더해 최대값을 찾는다.  -->시간초과
	
	// N이 100000인데 숫자의 범위는 1~100이므로 분명 중복된 수가 여러개있을것.
	// 쓸데없는 같은 계산을 스킵해가면 결국 시간복잡도가 100000x100000에서 100x100000으로 갈것이다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int A[] = new int[101]; // 작은 순서로
		int B[] = new int[101]; // 큰 순서로
		int[] temp1 =new int[101];
		int[] temp2 =new int[101];
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a]++;
			B[b]++;
			
					
		
			int Max = 0;
			int check = 0;
			int aa = 1, bb = 100;
			
			for(int j=1;j<101;j++) {
				temp1[j]=A[j];    //값을 지워야하니 복사본을 준비
				temp2[j]=B[j];
			}
			
			while (check != i) {
				while (aa<101 && temp1[aa] == 0) {	//현우가 부른 숫자라면			
					aa++;					
				}
				
				while (bb>=1 && temp2[bb] == 0) {					
					bb--;
				}
				
				if(aa>=101 && bb<1) break;    //범위를 벗어나면 더이상 값이 없는것이므로 긴급탈출
				
				check++;   //라운드 
				Max = Math.max(aa + bb, Max);
				
				int Min = Math.min(temp1[aa], temp2[bb]);  //시간초과를 방지하기위해 이미 계산한것은 스킵한다.
				temp1[aa]-=Min;
				temp2[bb]-=Min;
								
			}
			
			

			bw.write(Max+"\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}

}
