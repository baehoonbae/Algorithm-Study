import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {

    static int N, M, R, cnt;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
        
        cnt = Math.min(N, M)/2;
        for (int i = 0; i < R; i++) {
			rotate();
		}
        
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(map[r][c]+" ");
			}
			sb.append("\n");
		}
        
        System.out.println(sb.toString());
        
    }

	private static void rotate() {
		for (int t = 0; t < cnt; t++) {
			int r = t;
			int c = t;
			
			int tmp = map[r][c];
			
			int idx = 0;
			while (idx < 4) {
				int nr = r+dr[idx];
				int nc = c+dc[idx];
				
				if (nr<N-t && nc<M-t && nr>=t && nc>=t) {
					map[r][c] = map[nr][nc];
					r = nr;
					c = nc;
				} else {
					idx++;
				}
			}
			
			map[t+1][t] = tmp;
		}
	}
	
}
