import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1106 {
    
	static int C, N;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	C = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	dp = new int[C+101];
    	Arrays.fill(dp, 1000001);
    	dp[0] = 0;
    	    	
    	for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			for (int j = customer; j < C+101; j++) {
				dp[j] = Math.min(dp[j], dp[j-customer]+cost);
			}
		}
    	
    	int min = Integer.MAX_VALUE;
    	for (int i = C; i < C+101; i++) {
			min = Math.min(min, dp[i]);
		}
    	 	
    	System.out.println(min);
    }

}
