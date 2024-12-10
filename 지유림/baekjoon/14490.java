import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14490_백대열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 최대공약수(Math.max(n, m), Math.min(n, m));

        System.out.println(n / result + ":" + m / result);

    }

    static int 최대공약수(int n, int m) {
        if(m == 0) return n;
        return 최대공약수(m, n % m);
    }
}
