import java.io.*;
import java.util.*;

public class Main_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = Integer.MAX_VALUE;
		StringTokenizer substraction = new StringTokenizer(br.readLine(), "-");

		while (substraction.hasMoreTokens()) {
			int temp = 0;

			StringTokenizer addition = new StringTokenizer(substraction.nextToken(), "+");
			while (addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}

			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}