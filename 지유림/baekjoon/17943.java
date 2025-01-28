import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] prefixXOR = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (type == 0) {
                int xorResult = prefixXOR[y - 1] ^ prefixXOR[x - 1];
                sb.append(xorResult).append("\n");
            } else {
                int d = Integer.parseInt(st.nextToken());
                int xorResult = prefixXOR[y - 1] ^ prefixXOR[x - 1];
                int result = xorResult ^ d;
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }
}
