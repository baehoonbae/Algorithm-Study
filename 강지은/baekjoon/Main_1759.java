import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
    
	static int L, C;
	static char[] lang, dict;
	static StringBuilder sb;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	L = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	lang = new char[C];
    	dict = new char[L];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < C; i++) {
			lang[i] = st.nextToken().charAt(0);
		}
    	
    	Arrays.sort(lang);
    	
    	sb = new StringBuilder();
    	secret(0, 0, 0);
    	
    	System.out.println(sb.toString());
    }

	private static void secret(int idx, int cnt, int depth) {
		if (depth==L) {
			if (cnt==0 || L-cnt < 2) return;
			for (int i = 0; i < L; i++) {
				sb.append(dict[i]);
			}
			sb.append("\n");
			
			return;
		}
		
		for (int i = idx; i < C; i++) {
			dict[depth] = lang[i];
			if (lang[i]=='a' || lang[i]=='e' || lang[i]=='i' || lang[i]=='o' || lang[i]=='u') {
				secret(i+1, cnt+1, depth+1);
			} else {
				secret(i+1, cnt, depth+1);
			}
			
		}
	}

}
