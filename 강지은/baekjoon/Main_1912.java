import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {
    
	static int N;
	static int[] arr, sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sum = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        sum[0] = arr[0];
        
        int max = sum[0];
        for (int i = 1; i < N; i++) {
			sum[i] = Math.max(arr[i], sum[i-1]+arr[i]);
			max = Math.max(max, sum[i]);
		}
                
        System.out.println(max);
        
    }
    
}
