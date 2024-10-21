import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15989 {
    
	static int T, N;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		dp = new int[10001][10001];
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			dp[0][1] = 1;
			dp[1][1] = 1;
			dp[2][1] = 1;
			dp[2][2] = 1;
			
			for (int i = 3; i <= N; i++) {
				dp[i][1] = dp[i-1][1];
				dp[i][2] = dp[i-2][1]+dp[i-2][2];
				dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
			}
			
			System.out.println(dp[N][1]+dp[N][2]+dp[N][3]);
			
		}
		
	}

}
