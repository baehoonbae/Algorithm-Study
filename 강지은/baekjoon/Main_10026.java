import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    
	static int N;
	static char[][] map, Cmap;
	static boolean[][] Nvisit, Cvisit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		Cmap = new char[N][N];
		Nvisit = new boolean[N][N];
		Cvisit = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
			Cmap[r] = Arrays.copyOf(map[r], N);
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (Cmap[r][c]=='R') Cmap[r][c]='G';
			}
		}
		
		int normal = 0;
		int color = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!Nvisit[r][c]) {
					Nblock(r,c);
					normal++;
				}
				if (!Cvisit[r][c]) {
					Cblock(r,c);
					color++;
				}
			}
		}
		
		System.out.println(normal+" "+color);
		
	}

	private static void Cblock(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c});
		Cvisit[r][c] = true;
		char letter = Cmap[r][c];
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if(!check(nr,nc)) continue;
				if(Cmap[nr][nc]!=letter || Cvisit[nr][nc]) continue;
				que.add(new int[] {nr,nc});
				Cvisit[nr][nc] = true;
			}
		}
		
	}

	private static void Nblock(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c});
		Nvisit[r][c] = true;
		char letter = map[r][c];
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if(!check(nr,nc)) continue;
				if(map[nr][nc]!=letter || Nvisit[nr][nc]) continue;
				que.add(new int[] {nr,nc});
				Nvisit[nr][nc] = true;
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}

}
