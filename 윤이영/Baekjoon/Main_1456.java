import java.util.Arrays;
import java.util.Scanner;

// 에라토스테네스의 체 이용
// 1. 두 정수 A와 B
// 2. A <= 소수^2 <= B <= 10^14

public class Main_1456 {
	static long A, B;
	static int N;
	static int[] arr;
	static int count = 0;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		
		// 1. 에라토스테네스의 체 구현		
		N = (int) Math.sqrt(B+1);
		arr = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			arr[i] = i;
		}
		aes();
		//System.out.println("B = "+ B);
		// 2. 거의 소수인지 확인해보자
		ans = 0;
		for(int i=2; i<=N; i++) {
			if(arr[i] != 0){
				long temp = arr[i];
				// 10000000000000 100000000000000 -> 를 통과하기 위해서는 stackoverflow를 방지해줘야 한다.
				while(temp <= B / arr[i]) {
					temp *= arr[i];
					if(temp >= A && temp <= B) ans++;
				}
			}
		}
		System.out.println(ans);

	}
	
	
	// 에라토스테네스의 체
	private static void aes() {
		int a = 0;
		for(int i=2; i<=N; i++) {
			if(arr[i] != 0) {
				int num = arr[i];
				int j=2;
				while(num*j <= N) {
					if( arr[num*j]!= 0) {
						arr[num*j] = 0;
					}
					j++;
				}
			}
		}
	}
}
