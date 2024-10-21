import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_24891 {
    
	static int L, N;
	static String[] letter, ans;
	static boolean[] visit;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		letter = new String[N];
		ans = new String[L];
		visit = new boolean[N];
		flag = false;
		
		for (int i = 0; i < N; i++) {
			letter[i] = br.readLine();
		}
		
		Arrays.sort(letter);
		select(0);
		
		if (!flag) {
			System.out.println("NONE");
		} else {
			for (String s : ans) {
				System.out.println(s);
			}
		}
		
	}

	private static void select(int depth) {
		if (depth==L) {
			if (isPossible()) flag = true;			
			return;
		}
		
		for (int i = 0; !flag && i < N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			ans[depth] = letter[i];
			select(depth+1);
			visit[i] = false;
		}
	}

	private static boolean isPossible() {
		for (int r = 0; r < L; r++) {
			for (int c = 0; c < L; c++) {
				if (ans[r].charAt(c) != ans[c].charAt(r))
					return false;
			}
		}
		
		return true;
	}

}
