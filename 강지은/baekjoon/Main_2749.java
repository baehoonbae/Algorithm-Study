import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main_2749 {

    static long N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 피사노 주기
        // 피보나치 수열의 N번째 값을 M으로 나누었을 때
        // P의 주기로 같은 값이 나오는 주기
        
        // M = 1000000 = 10^6 (6=k)
        // P = 15*10^5 (5=k-1) = 1500000
        
        // 따라서 N번째 값을 M으로 나눈 값을 구하는 공식은
        // N%P % M
        
        int P = 1500000;
        N = Long.parseLong(br.readLine())%P;
        
        long[] dp = new long[P+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i < P+1; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%1000000;
		}
        
        System.out.println(dp[(int)N]);
        
    }

}
