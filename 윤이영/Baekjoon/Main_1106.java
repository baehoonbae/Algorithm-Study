import java.util.Arrays;
import java.util.Scanner;

public class Main_1106 {
	static int C, N;
	static int ans = Integer.MAX_VALUE;
	static int[] dp;
	static int[] cost;
	static int[] person;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();	// 목표 고객
		N = sc.nextInt();	// 도시
		
		dp= new int[C+100];
		cost = new int[N+1];
		person = new int[N+1];
		
		// min값으로 정답을 찾을 것이기 때문에 최대값으로 배열을 채운다.
		Arrays.fill(dp, 1000000);
		dp[0] = 0;
		
		for(int i=1; i<=N; i++) {
			cost[i] = sc.nextInt();
			person[i] = sc.nextInt();
		}
		
		
		for(int i=1; i<=N; i++) {	//N개의 도시를 돌면서
			for(int j=person[i]; j<dp.length; j++) {
				// 기존 J명을 유치하는 비용과, 현재 도시에서 person[i]명을 추가로 유치하는 비용을 비교
				dp[j] = Math.min(dp[j-person[i]] + cost[i], dp[j]);
			}
		}
		
		// 달성된 목표 중에서 최소 비용을 찾는다.
		for(int i=C; i<dp.length; i++) {
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
