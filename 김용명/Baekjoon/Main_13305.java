import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance = new long[N - 1];
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long[] city = new long[N];
		for (int i = 0; i < N ; i++) {
			city[i] = Long.parseLong(st.nextToken());
		}

		long ans = 0;
		long min = city[0];

		for (int i = 0; i < N - 1; i++) {
			if (city[i] < min) {
				min = city[i];
			}
			ans += min * distance[i];
		}

		System.out.println(ans);

	}
}
