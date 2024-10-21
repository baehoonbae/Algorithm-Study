import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
    
	static int T, N;
	static int sr, sc, er, ec;
	static boolean[][] visit;
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			int count = move(sr, sc, 0);
			System.out.println(count);
		}
		
	}

	private static int move(int r, int c, int cnt) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c,cnt});
		visit[r][c] = true;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			if (cur[0] == er && cur[1] == ec) {
				return cur[2];
			}
			
			for (int d = 0; d < 8; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) continue;
				if (visit[nr][nc]) continue;
				que.add(new int[] {nr, nc, cur[2]+1});
				visit[nr][nc] = true;
			}
		}
		
		return -1;
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}

}
