import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 미리 구하기
public class Main15989_123더하기4 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		// 합이 3 이하면 미리 1씩 채워두기
		int[][] dp = new int[10001][4];
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
		
		for(int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		
		for(int i= 0; i< N; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][1] + dp[num][2] + dp[num][3] + "\n");
		}
		
		System.out.println(sb);
	}
}
