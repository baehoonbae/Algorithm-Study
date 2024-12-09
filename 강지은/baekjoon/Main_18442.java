import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18442 {
	
    static int V, P;
    static long L;
    static long[] village, post, select;
    static long min = Long.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	V = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	L = Long.parseLong(st.nextToken());
    	
    	village = new long[V];
    	post = new long[P];
    	select = new long[P];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < V; i++) {
			village[i] = Long.parseLong(st.nextToken());
		}
    	
    	selectPost(0, 0);
    	
    	System.out.println(min);
        for (Long post : select) {
			System.out.print(post+" ");
		}
    }

	private static void selectPost(int idx, int depth) {
		if (depth==P) {
			long sum = 0;
			
			for (int i = 0; i < V; i++) {
				long close = Long.MAX_VALUE;
				for (int j = 0; j < P; j++) {
					long dist = Math.min(Math.abs(village[i]-post[j]), L-Math.abs(village[i]-post[j]));
					close = Math.min(close, dist);
				}
				
				sum += close;
			}
			
			if (min > sum) {
				min = sum;
				select = Arrays.copyOf(post, P);
			}
			
			return;
		}
		
		for (int i = idx; i < V; i++) {
			post[depth] = village[i];
			selectPost(i+1, depth+1);
		}
		
	}
    
    
}
