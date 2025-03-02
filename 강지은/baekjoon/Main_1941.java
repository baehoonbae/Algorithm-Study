import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Main_1941 {

    static char[][] student;
    static boolean[][] visit, select;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        student = new char[5][5];
        select = new boolean[5][5];
        
        for (int r = 0; r < 5; r++) {
			student[r] = br.readLine().toCharArray();
		}
        
        ans = 0;
        dfs(0, 0, 0);
        
        System.out.println(ans);
    }

	private static void dfs(int idx, int s, int cnt) {
		if (cnt == 7) {
			if (s >= 4 && isConnect()) {
				ans++;
			}
			return;
		}
		
		if (idx >= 25) return;
		
		int r = idx/5;
		int c = idx%5;
		
		select[r][c] = true;
		
		if (student[r][c]=='S') {
			dfs(idx+1, s+1, cnt+1);
		} else {
			dfs(idx+1, s, cnt+1);
		}
		
		select[r][c] = false;
		dfs(idx+1, s, cnt);
	}

	private static boolean isConnect() {
		Queue<int[]> que = new LinkedList<>();
		visit = new boolean[5][5];
		
		int sr = -1;
		int sc = -1;
		out: for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (select[r][c]) {
					sr = r;
					sc = c;
					break out;
				}
			}
		}
		
		que.add(new int[] {sr, sc});
		visit[sr][sc] = true;
		int cnt = 1;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) continue;
				if (visit[nr][nc]) continue;
				
				if (select[nr][nc]) {
					visit[nr][nc] = true;
					que.add(new int[] {nr, nc});
					cnt++;
				}
			}
			
		}
		
		return cnt==7;
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<5 && 0<=c && c<5;
	}

	
}
