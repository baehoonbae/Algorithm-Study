import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21609 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] rainbowvisited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int ans;
	
	static class block implements Comparable<block>{
		int r, c, rainbow, size;
		List<int[]> removelist;
		public block(int r, int c, int rainbow, int size, List<int[]> removeList) {
			super();
			this.r = r;
			this.c = c;
			this.rainbow = rainbow;
			this.size = size;
			this.removelist = removeList;
		}
		@Override
		public int compareTo(block o) {
			if(this.size == o.size) {
				if(this.rainbow == o.rainbow) {
					if(this.r == o.r) {
						return Integer.compare(o.c, this.c);
					}
					return Integer.compare(o.r, this.r);
				}
				return Integer.compare(o.rainbow, this.rainbow);
			}
			return Integer.compare(o.size, this.size);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	// 블록의 색상
		
		map = new int[N][N];
		//rainbowvisited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			// 1. 가장 큰 블럭을 찾는다 - 우선순위큐 이용
			PriorityQueue<block> pq = new PriorityQueue<>();
			visited = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] > 0 && map[r][c] != 10 && !visited[r][c]) {
						block block = findLargeBlock(r, c);	// 일반 블럭일 경우에만 찾기
						pq.add(block);
					}
				}
			}
			
			// 우선순위 큐가 비어있거나, 사이즈가 2보다 작은 경우 반복문 중단.
			if(pq.isEmpty()) break;
			block maxblock = pq.poll();
			if(maxblock.size < 2) {
				break;
			}
			// 2. 가장 큰 블럭을 제거하고, 점수를 획득한다 (이떄 블럭을 m보다 큰 수로 바꾼다.)
			ans +=  maxblock.size * maxblock.size;
			List<int[]> removeList = maxblock.removelist;
			for(int[] pos : removeList) {
				map[pos[0]][pos[1]] = 10;
			}
			
			//3. 중력 작용
			down();
			/// 4. 격자 회전
			rotate();
			// 5. 다시 중력 작용
			down();
		}
		System.out.println(ans);
	}

	private static void rotate() {
		int[][] temp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = temp[c][N-r-1];
			}
		}
		
	}

	private static void down() {
		for(int r=N-2; r>=0; r--) {
			for(int c=0; c<N; c++) {
				if(map[r][c] != 10 && map[r][c] != -1) {
					int nr = r;
					while(nr+1 < N && map[nr+1][c] == 10) {
						nr++;
					}
					if(nr != r) {
						map[nr][c] = map[r][c];
						map[r][c] = 10;
					}
				}
			}
		}
	}

	// 가장 큰 영역의 블럭을 찾기
	private static block findLargeBlock(int sr, int sc) {
		
		rainbowvisited = new boolean[N][N];
		Queue<int[]> que = new LinkedList<>();
		visited[sr][sc] = true;
		List<int[]> remove = new ArrayList<>();
		int n = map[sr][sc];
		int count = 1;
		int rainbow = 0;
		que.add(new int[] {sr, sc});
		
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			remove.add(new int[] {r, c});
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr, nc)) continue;	// map 배열 내에 있는 것
				if(visited[nr][nc] || rainbowvisited[nr][nc]) continue;	// 검정 블럭이 아니면서 방문한 적 없는 곳
				if(map[nr][nc] == 0 || map[nr][nc] ==  n) {
					que.add(new int[] {nr, nc});
					count++;
					if(map[nr][nc] == 0) {
						rainbow++;
						rainbowvisited[nr][nc] = true;
					}
					else {
						visited[nr][nc] = true;
					}
				}
			}
		}
		return new block(sr, sc, rainbow, count, remove);
	}
	private static boolean check(int r, int c) {
		return r >= 0 && r<N && c>=0 && c<N;
	}
}





