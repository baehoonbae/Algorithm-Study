import java.util.Scanner;

public class Main_15989 {
	static int n;
	static int[][] dp = new int[10001][4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		dp[1][1] = 1;
		dp[2][1] = 1;      // 1+1
		dp[2][2] = 1;     // 2
		dp[3][1] = 1;    // 1+1+1
		dp[3][2] = 1;   // 1+2
		dp[3][3] = 1;  // 3
		
		
		for(int i=4; i<=10000; i++) {
			dp[i][1] = 1;	// 뒤에 1을 붙이는 경우
			dp[i][2] = dp[i-2][1] + dp[i-2][2];		// 뒤에 2를 붙이는 경우
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]; // 뒤에 3을 붙이는 경우
		}
		
		for(int i=0; i<T; i++) {
			n = sc.nextInt();
			int sum = dp[n][1] + dp[n][2] + dp[n][3];
			//System.out.println(dp[n][1]+" " + dp[n][2]+ " " + dp[n][3]);
			System.out.println(sum);
		}
	}
}
