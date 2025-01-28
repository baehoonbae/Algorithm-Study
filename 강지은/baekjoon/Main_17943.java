import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17943 {

    static int N, Q;
    static int[] domino, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        domino = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
			domino[i] = Integer.parseInt(st.nextToken());
		}
        
        arr = new int[N];
        for (int i = 1; i < N; i++) {
			arr[i] = arr[i-1] ^ domino[i];
		}
        
        for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 0) {
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				
				System.out.println(arr[x] ^ arr[y]);
			} else {
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int d = Integer.parseInt(st.nextToken());
				
				System.out.println(arr[x]^arr[y]^d);
			}
		}
        
        
    }

	
}
