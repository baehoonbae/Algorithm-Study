import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {
	
    static int N;
    static int[] num, op, select;
    static int max, min;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	num = new int[N];
    	op = new int[4];
    	select = new int[N-1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
    	
    	max = Integer.MIN_VALUE;
    	min = Integer.MAX_VALUE;
    	
    	perm(0);
    	
    	System.out.println(max);
    	System.out.println(min);
    	
    }

	private static void perm(int depth) {
		if (depth==N-1) {
			int res = num[0];
			for (int i = 0; i < N-1; i++) {
				// 덧셈
				if (select[i]==0) {
					res += num[i+1];
				}
				// 뺄셈
				if (select[i]==1) {
					res -= num[i+1];
				}
				// 곱셈
				if (select[i]==2) {
					res *= num[i+1];
				}
				// 나눗셈
				if (select[i]==3) {
					if (res < 0) {
						res *= -1;
						res /= num[i+1];
						res *= -1;
					} else {
						res /= num[i+1];
					}
				}
			}
			
			max = Math.max(max, res);
			min = Math.min(min, res);
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (op[i] == 0) continue;
			select[depth] = i;
			op[i]--;
			perm(depth+1);
			op[i]++;
		}
		
	}    
    
}
