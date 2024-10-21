import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8901 {
    
	static int T;
	static int chem[], mix[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			chem = new int[3];
			mix = new int[3];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				chem[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				mix[i] = Integer.parseInt(st.nextToken());
			}
			
			int min=chem[0];
			int idx=0;
			if (min > chem[1]) {
				min = chem[1];
				idx=1;
			}
			if (min > chem[2]) {
				min = chem[2];
				idx = 2;
			}
			
			int max = 0;
			for (int i = 0; i <= min; i++) {
				int remain1 = chem[(idx+2)%3]-i;
				int remain2 = chem[idx]-i;
				int use1 = Math.min(chem[(idx+1)%3], remain2);
				
				for (int j = 0; j <= use1; j++) {
					int sum =  mix[(idx+2)%3]*i;
					sum += mix[idx]*j;
					
					int remain3 = chem[(idx+1)%3]-j;
					int use2 = Math.min(remain1, remain3);
					sum += mix[(idx+1)%3]*use2;
					max = Math.max(max, sum);
				}
				
			}
			
			System.out.println(max);
		}
		
	}

}
