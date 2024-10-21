import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		result = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int prev = 0;
		for(int i = 0; i < N; i++) {
			sum += prev + arr[i];
			
			prev += arr[i];
		}
		
		
		System.out.println(sum);
		
	}
}
