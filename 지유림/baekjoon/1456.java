import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 10의 14승; 제곱하면 long도 넘음 -> 루트!
public class Main1456_거의소수 {
	static long A, B;
	static boolean[] isDecimal;
	static int[] sosu;
	static List<Long> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B =  Long.parseLong(st.nextToken());
		
		isDecimal = new boolean[(int) Math.sqrt(B) + 1];
		
		에라토스테네스의체();
		System.out.println(거의소수());
		
		
	}
	
	// 에라토스테네스의 체 사용
	static void 에라토스테네스의체() {
		for(int i = 2; i < isDecimal.length; i++) {
			if(isDecimal[i]) continue; // 소수면 건너뛰기
			
			// i의 배수가 소수인거니까 표기하기
			for(int j = i*2; j < isDecimal.length; j+=i) {
				isDecimal[j] = true;
			}
		}
	}
	
	// 소수찾기 제곱근!
	static int 거의소수() {
		int count = 0;
		for(int i = 2; i < isDecimal.length; i++) {
			if(!isDecimal[i]) {
				long num = i;
				
				while((double)num <= (double)B/i) {
					if((double)num >= (double)A/i) {
						count++;
					}
					
					num *= i;
				}
			}
		}
		
		return count;
	}
}
