import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052 {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int buy = 0;

        while (true) {
            int tmp = N;
            int cnt = 0;

            while (tmp > 0) {
                if (tmp % 2 == 1) {
                    cnt++;
                }
                tmp /= 2;
            }

            if (cnt <= K) {
                break;
            }

            buy += 1;
            N += 1;
        }

        System.out.println(buy);
    }
}
