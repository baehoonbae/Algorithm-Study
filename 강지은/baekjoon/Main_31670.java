import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_31670 {

    static int N;
    static long[] R;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = new long[N];
        dp = new long[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            R[i] = Long.parseLong(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        dp[0][0] = 0;
        dp[0][1] = R[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.min(dp[i-1][0]+R[i], dp[i-1][1]+R[i]);
        }

        System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
    }

}
