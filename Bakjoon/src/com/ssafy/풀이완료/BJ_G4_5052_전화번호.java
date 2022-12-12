package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G4_5052_전화번호 {
	
	// 길이순 정렬  <= 시간초과뜸
	// 문자의 사전적 정렬 <= 앞에글자가 전부 순서대로 옴
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			String n[] = new String[N];
			
			for(int i=0;i<N;i++) {
				n[i] = br.readLine();
			}
			
			Arrays.sort(n);  //정렬하면 앞에서부터 같은문자들 끼리 모인다
//			
//			System.out.println(Arrays.toString(n));
			boolean No = false;
			for(int i=0;i<N-1;i++) {
				if(n[i].length()==n[i+1].length()) continue;  //둘의 길이가 같으면 비교할 필요없음 (조건 = 같은 번호는 주어지지않는다)
				
				No=true;  //일단 일관성이 없다고 설정해두고
				for(int k=0;k<n[i].length();k++) {
					
					if(n[i].charAt(k)!=n[i+1].charAt(k)) {  //만약 두 번호가 일관성이 있으면
						No=false;  //앞에 설정해둔거 바꿔주고 나옴
						break;
					}
				}
				if(No) {  //한번이라도 일관성이 없는 번호가 발견되면 더이상 할 필요없다
					break;
				}
			}
			
			if(No) bw.write("NO\n");
			else bw.write("YES\n");
			
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
