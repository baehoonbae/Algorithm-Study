import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442 {
	
    static int N, M, K;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static class Node {
    	int r;
    	int c;
    	int attack;
    	int cnt;
    	
		public Node(int r, int c, int attack, int cnt) {
			this.r = r;
			this.c = c;
			this.attack = attack;
			this.cnt = cnt;
		}
		
    }
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visit = new boolean[N][M][K+1];
        for (int r = 0; r < N; r++) {
        	map[r] = br.readLine().toCharArray();
		}
        
        bfs(0, 0);
        
    }

	private static void bfs(int r, int c) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(r, c, 0, 1));
		visit[r][c][0] = true;
		
		while (!que.isEmpty()) {
			Node cur = que.poll();
						
			if (cur.r==N-1 && cur.c==M-1) {
				System.out.println(cur.cnt);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if (!check(nr, nc)) continue;
				if (visit[nr][nc][cur.attack]) continue;
				if (cur.attack < K && map[nr][nc] == '1' && !visit[nr][nc][cur.attack+1]) {
					que.add(new Node(nr,nc,cur.attack+1, cur.cnt+1));
					visit[nr][nc][cur.attack+1] = true;
				}
				if (map[nr][nc] == '0') {
					que.add(new Node(nr, nc, cur.attack, cur.cnt+1));
					visit[nr][nc][cur.attack] = true;
				}
				
			}
			
		}
		
		System.out.println(-1);
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
    
    
}
