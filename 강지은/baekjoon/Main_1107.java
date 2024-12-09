import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1107 {
	
    static int N, M; 
    static List<Integer> error;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	error = new ArrayList<>();
    	
    	if (M==0) {
    		int min = Math.min(String.valueOf(N).length(), Math.abs(N-100));
    		System.out.println(min);
    		return;
    	}
    	
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
			error.add(Integer.parseInt(st.nextToken()));
		}
        
        if (N==100) {
        	System.out.println(0);
        	return;
        }
        
        int min = Math.abs(100-N);
        
        for (int i = 0; i < 1000000; i++) {
			String channel = String.valueOf(i);
			boolean isPossible = true;
			
			for (int j = 0; j < channel.length() && isPossible; j++) {
				int num = channel.charAt(j)-'0';
				if (error.contains(num)) {
					isPossible = false;
					break;
				}
			}
			
			if (isPossible) {
				int cnt = Math.abs(N-Integer.parseInt(channel))+channel.length();
				min = Math.min(min, cnt);
			}
			
		}
        
        System.out.println(min);
        
    }
    
    
}
