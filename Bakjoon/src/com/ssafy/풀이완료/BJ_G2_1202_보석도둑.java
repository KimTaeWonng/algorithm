package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class BJ_G2_1202_보석도둑 {
	
	static class jewelry implements Comparable<jewelry>{     //객체생성
		int weight;
		int price;
		
		public jewelry(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(jewelry o) {			  		//무게순 정렬
			return (this.weight -o.weight);
		}

		@Override
		public String toString() {
			return "jewelry [weight=" + weight + ", price=" + price + "]";
		}
		
			
	}
	//보석을 가치순으로 정렬해서 넣는다.
	
	//보석을 무게순으로 정렬해서 넣는다.
	
	//우선순위큐 j가 시간초과의 원인?  <- 그냥 배열로 해본다
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<jewelry> j = new ArrayList<>();
		PriorityQueue<Integer> bag = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			j.add(new jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));		
		}
		
		
		for(int i=0;i<K;i++) {
			bag.add(Integer.parseInt(br.readLine()));
		}  
		
		//--------------------------------------까지 입력부분-------------------------------------------
		
		Collections.sort(j); //기존에 설정해둔 기준에 따라 정렬
		
		
		long cnt=0;  //혹시몰라서 오버플로우날까봐 long으로
		
		PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder()); //보석의 가치만 가져와서 내림차순으로 정렬
		
		int get=0;
		while(K!=0) {	//가방의 개수만큼 반복		
			int k = bag.peek();  //가방도 오름차순으로 정렬된상태 = 작은 가방부터
			
			for(int i=get;i<N;i++) {
				if(j.get(i).weight<=k) {
					jewelry je = j.get(i);
					temp.add(je.price);  	//가방에 넣을수 있는 보석들중 최고 가치순으로 정렬
					get++;  				//다음가방은 이거보다 더 큰가방이므로 이전에 들어갔던 거는 무조건 들어간다. (시간절약) 
				}else {						//그리고 0부터하면 이미 가방에넣은거 또집어넣음 
					break;
				}
			}

			if(!temp.isEmpty()) {
				cnt+=temp.poll();   //어차피 우선순위큐이므로 가장 높은 가치의 보석이 가장 앞에있음
				
			}
								
			bag.poll();  //다쓴 가방은 버려
			
			K--;
		}
		
		System.out.println(cnt);
		
		

	}

}
