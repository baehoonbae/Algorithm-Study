import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] res = new int[2];

        int s = 0, e = N - 1, ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        while (s < e) {
            int sum = arr[s] + arr[e];

            if (ans > Math.abs(sum)) {
                ans = Math.abs(sum);

                res[0] = arr[s];
                res[1] = arr[e];

                if (sum == 0) break;
            }

            if (sum < 0) s++;
            else e--;
        }

        System.out.println(res[0] + " " + res[1]);

    }
}
