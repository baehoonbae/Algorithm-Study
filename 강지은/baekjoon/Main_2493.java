import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int top = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= top) {
					sb.append(stack.peek()[0]+" ");
					break;
				}
				
				stack.pop();
			}
			
			if (stack.isEmpty()) sb.append("0 ");
			
			stack.push(new int[] {i+1, top});
			
		}
		
		System.out.println(sb.toString());
	}

}
