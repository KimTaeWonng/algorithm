package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_5710_전기요금 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			if (A == 0 && B == 0)
				break;

			long full = 0;

			if (A <= 200) {
				full = A / 2;
			} else if (A <= 29900) {
				full = (A - 200) / 3 + 100;
			} else if (A <= 4979900) {
				full = (A - 29900) / 5 + 10000;
			} else {
				full = (A - 4979900) / 7 + 1000000;
			}
			
			long left = 0;
			long right = full / 2;
			
			while(left<=right) {
				long mid = (left + right)/2;
				
				long sang = price(mid);
				long neigh = price(full-mid);
				
				long sum = neigh - sang;
				
				if(sum <B) {
					right = mid -1;
				}else if (sum>B) {
					left = mid+1;
				}else {
					bw.write(sang+"\n");
					break;
				}
				
				
			}
		}
		bw.flush();

	}
	
	public static long price(long elec) {
        if(elec <= 100) {
            return elec * 2;
        } else if(elec <= 10000) {
            return 200 + (elec - 100) * 3;
        } else if(elec <= 1000000) {
            return 200 + 29700 + (elec - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (elec - 1000000) * 7;
        }
    }

}
