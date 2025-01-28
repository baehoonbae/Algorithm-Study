import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719 {

    static int H, W;
    static int[] block;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W];
        map = new int[H][W];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
        
        for (int r = 0; r < W; r++) {
			for (int c = H-block[r]; c < H; c++) {
				map[c][r] = 1;
			}
		}
        
        int sum = 0;
        for (int r = 0; r < H; r++) {
			sum += calc(r);
		}
        
        System.out.println(sum);
    }

	private static int calc(int r) {
		boolean flag = false;
		int cnt = 0;
		int rain = 0;
		
		for (int c = 0; c < W; c++) {
			if (!flag) {
				if (map[r][c]==1) {
					flag = true;
				}
			} else {
				if (map[r][c]==0) {
					rain++;
				} else {
					cnt += rain;
					rain = 0;
					if (c+1 < W && map[r][c+1]==0) continue;
					flag = false;
				}
			}
		}
		return cnt;
	}

	
}
