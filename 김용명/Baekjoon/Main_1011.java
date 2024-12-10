import java.io.*;
import java.util.*;

// 숨바꼭질 문제와 비슷하게 bfs로 풀어야하는 문제인줄 알았음
// dp는 아니지만 단순한 수학적 패턴을 발견하면 쉽게 풀리는 문제.. 
public class Main {
	
	static int T, x, y;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int dif = y - x;
			
			int max = (int) Math.sqrt(dif);
			
			if (max == Math.sqrt(dif)) System.out.println(max*2 - 1);
			else if (dif <= max*max + max) System.out.println(max*2);
			else System.out.println(max*2 + 1);
		}

	}

}
