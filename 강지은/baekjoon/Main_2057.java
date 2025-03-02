import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main_2057 {

    static long N;
    static long[] fact, sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        if (N == 0) {
            System.out.println("NO");
            return;
        }

        fact = new long[21];
        fact[0] = 1L;

        for (int i = 1; i < 21; i++) {
            fact[i] = fact[i - 1] * i;
        }

        for (int i = 20; i >= 0; i--) {
            if (N >= fact[i]) {
                N -= fact[i];
            }
        }

        System.out.println(N == 0 ? "YES" : "NO");
    }

}
