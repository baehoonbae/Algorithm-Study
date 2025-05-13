import java.io.*;
import java.util.*;

public class Main_32981 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(solution(N)).append('\n');
        }

        System.out.print(sb);
    }

    private static long solution(int N) {
        final int M = 1000000007;

        if (N == 1) {
            return 5;
        }

        return (4 * pow(5, N-1, M)) % M;
    }

    private static long pow(long a, long b, int mod) {
        long result = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return result;
    }
}