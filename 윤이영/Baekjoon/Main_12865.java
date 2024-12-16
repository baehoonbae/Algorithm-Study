// 평범한 배낭

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
	static int N, K;
	static int[][] dp;
	static int[] W;
	static int[] V;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 물품의 수
		K = Integer.parseInt(st.nextToken());	// 버틸 수 있는 무게
		
		W = new int[N+1];
		V = new int[N+1];
		dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		// i는 물건의 갯수 , K는 무게
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				dp[i][j] = dp[i-1][j];	// 디폴트: i번 물건을 넣지 않은 경우의 가치
				if(j-W[i] >= 0) // 현재의 물건(i번 물건)을 넣을 수 있는 공간이 남은 경우
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]] + V[i]);	// i번 물건을 넣었을 떄와 넣지 않았을 때를 비교하여 더 큰 가치를 선택
				// i번 물건을 넣는 경우: 남은 공간에서의 최대 가치 (dp[i-1][j-W[i]] 에 현재 물건의 가치를 더한다)_
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
