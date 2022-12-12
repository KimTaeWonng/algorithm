package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G1_1700_멀티탭스케줄링 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=  new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[b+1];
		int[] number = new int[b+1];
		int[] concent = new int[a];
		
		int cnt=0;
		String[] temp = br.readLine().split(" ");
		
		for(int i=0;i<b;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=0;i<b;i++) {
			number[arr[i]]++;
		}
		
		for(int i=0;i<b;i++) {
			//System.out.println(Arrays.toString(number));
			//System.out.println(Arrays.toString(concent));
			if(i<a) {
				for(int j=0;j<a;j++) {
					if(concent[j]==arr[i]) {
						cnt--;
						break;
					}
				}
				concent[i] = arr[i];
				number[arr[i]]--;
			}else {
				boolean check = false;
				for(int j=0;j<a;j++) {
					if(concent[j]==arr[i]) {
						check=true;
						number[arr[i]]--;
						break;
					}
				}
				if(check) continue;
				else {
					cnt++;
					int max=0;
					int idx=0;
					boolean easy = false;
					
					for(int j=0;j<a;j++) {
						if(number[concent[j]]==0) {
							concent[j] = arr[i];
							number[arr[i]]--;
							easy = true;
							break;
						}
					}
					for(int j=0;j<a;j++) {
						if(easy) break;
						for(int k=i;k<b;k++) {
							if(concent[j]==arr[k]) {
								int id = k;
								if(max<id) {
									max = id;
									idx = j;
									//System.out.println(concent[j]+" "+idx+" "+max);								
								}
								break;
							}
						}
					}
					if(!easy) {
						//System.out.println(i+" "+idx);
						concent[idx] = arr[i];
						number[arr[i]]--;
					}
				}
			}
			
			
			
			
		}
		//System.out.println(Arrays.toString(number));
		//System.out.println(Arrays.toString(concent));
		if(cnt<0) {
			cnt=0;
		}
		System.out.println(cnt);
	}

}
