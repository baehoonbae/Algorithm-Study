import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// int로 하면 범위 벗어남..ㅠㅠ
public class Main1629_곱셈 {
	static long A, B, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B, C));
	}
	
	static long pow(long a, long b, long c) {
		if(b == 1) return a % c;	// 1이면 끝
		long num = pow(a, b/2, c);
		
		if(b%2 != 0) {
			return (num*num % c) * a%c; // 10^5 처럼 홀수면 10^2 10^2 10
		} else { // 짝수면..
			return num*num%c;
		}
	}
}
