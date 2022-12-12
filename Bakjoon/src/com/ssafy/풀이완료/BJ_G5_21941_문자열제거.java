package com.ssafy.풀이완료;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_21941_문자열제거 {
	
	static class point implements Comparable<point>{
		String str;
		int n;
		
		public point(String str, int n) {
			this.str = str;
			this.n = n;
		}

		@Override
		public int compareTo(point o) {
			if((double)this.n/this.str.length() - (double)o.n/o.str.length()>0) {
				return -1;
			}else return 1;
				
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String str = br.readLine();
		int cnt=0;
		
		int N = Integer.parseInt(br.readLine());
		point[] p = new point[N];
		//System.out.println(N);
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			p[i]= new point(st.nextToken(),Integer.parseInt(st.nextToken()));
			if(p[i].n<p[i].str.length()) {        //지운 점수가 2번째방법보다 작으면
				p[i].n=p[i].str.length();
			}
		}
		
		Arrays.sort(p);
		//System.out.println(p[0].n+" "+p[1].n);
		
		for(int i=0;i<N;i++) {
			while(str.contains(p[i].str)) {
				cnt+=p[i].n;
				str = str.replaceFirst(p[i].str, "_");
				//System.out.println(str);
			}
		}
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!='_') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		

	}

}
