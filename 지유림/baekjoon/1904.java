import java.util.Scanner;

public class Main {
	static int[] dp;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		if(N > 2) {
			dp = new int[N+1];
			
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i < dp.length; i++) {
				dp[i] = -1;
			}
			
			System.out.println(tile(N));
		} else {
			System.out.println(N);
		}
		
	}
	
	static int tile(int n) {
		if(dp[n] == -1) {
			dp[n] = (tile(n-1) + tile(n-2)) % 15746;
		}
		
		return dp[n];
	}
}
