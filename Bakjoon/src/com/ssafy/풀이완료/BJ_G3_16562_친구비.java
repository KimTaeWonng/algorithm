package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G3_16562_친구비 {
	static class friends{   //객체 생성
		int friend;  //누구와 친구인가?
		int money;   // 친구비는 얼마인가?
		
		public friends(int friend, int money) {
			super();
			this.friend = friend;
			this.money = money;
		}

		@Override
		public String toString() {
			return "friends [friend=" + friend + ", money=" + money + "]";
		}
		
		
	}
	static int N,M,money;
	static friends f[];
	
	static int findSet(int a) {
		if(f[a].friend==a) {
			return a;
		}else {
			return f[a].friend = findSet(f[a].friend);
		}
	}
	
	static void unionSet(int a,int b) {
		int aRoot = findSet(f[a].friend);
		int bRoot = findSet(f[b].friend);
		if(aRoot == bRoot) {
			return;
		}else {
			int min = Math.min(f[aRoot].money, f[bRoot].money);
			for(int i=0;i<N;i++) {
				if(f[i].friend==aRoot || f[i].friend==bRoot) {  //루트노드가 바뀌면 루트노드와 같은 친구였던 애들을 전부 바꿔줌 
					f[i].money = min;
				}
				if(f[i].friend==bRoot) {
					f[i].friend=aRoot;
				}
			}
			f[bRoot].money = min;  //두 친구의 최소비용으로 친구비를 낼수있다.
			f[aRoot].money = min;
			f[bRoot].friend = aRoot; 
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		money = Integer.parseInt(st.nextToken());
		f = new friends[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			f[i] = new friends(i, Integer.parseInt(st.nextToken()));
			//System.out.println(f[i].toString());
		}
		//System.out.println();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(findSet(f[a].friend)>findSet(f[b].friend)) {   //항상 왼쪽이 작은 index가 오도록
				int temp=a;
				a= b;
				b= temp;
			}
			unionSet(a, b);
		}
		
		for(int i=0;i<N;i++) {
			//System.out.println(f[i].toString());
		}
		
		boolean[] check = new boolean[N];  //이미 친구인지 확인
		boolean ohno = false;
		int answer=0;
		
		for(int i=0;i<N;i++) {
			if(!check[f[i].friend]) {
				check[f[i].friend]=true;
				answer+= f[i].money;
			}
			if(money<answer) {    //내 돈보다 친구비가 더 많이들어가
				ohno=true;
				break;
			}
		}
		if(ohno) System.out.println("Oh no");
		else System.out.println(answer);
		
		

	}

}
