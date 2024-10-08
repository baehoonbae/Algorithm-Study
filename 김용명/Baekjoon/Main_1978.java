import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if(isPrime(arr[i])) {
				count++;
			}
		}
		System.out.println(count);

	}
	
	static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}

}
