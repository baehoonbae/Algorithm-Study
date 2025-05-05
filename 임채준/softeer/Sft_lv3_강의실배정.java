package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_강의실배정 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map, (a, b) -> {
		    if (a[1] == b[1]) return a[0] - b[0];
		    return a[1] - b[1];
		});
		
		int count = 0;
		int end = 0;
		
		for(int i = 0; i < N; i++) {
			if(map[i][0] >= end) {
				count++;
				end = map[i][1];
			}
		}
		
		System.out.println(count);

	}

}
