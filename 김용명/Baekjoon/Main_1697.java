import java.io.*;
import java.util.*;

// 연산을 해서 나온 수를 배열에 연산을 몇번 거쳤는지 확인하는 문제
public class Main_1697 {
	
	static int N, K;
	static int[] check;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new int[100001];	
		
		if (N == K) {	// tc에서 같은 수가 나오는 경우 고려 해주어야 함.
			System.out.println(0);
		}else {
			bfs(N);			
		}

	}

	static void bfs(int num) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(num);
		check[num] = 1;
		
		while (!que.isEmpty()) {
			int temp = que.poll();
			
			 for (int i = 0; i < 3; i++) {
				 int next;

				 if (i == 0) {
					 next = temp + 1;
				 } else if (i == 1) {
					 next = temp - 1;
				 } else {
					 next = temp * 2;
				 }

				 if (next == K) {
					 System.out.println(check[temp]);
					 return;
				 }

				 if (next >= 0 && next < check.length && check[next] == 0) {
					 que.add(next);
					 check[next] = check[temp] + 1;
				 }
			 }
			 
		}
		 
	}
	
}


