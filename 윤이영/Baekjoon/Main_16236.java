import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 자신의 크기보다 작은 물고기만 먹을 수 있음
// 자신의 크기만큼 물고기의 개수를 먹어야, 크기가 1 증가함
// 자신의 크기와 같은 물고기는 지나갈 수 있음
/*
 * 1. 아기 상어의 위치를 찾는다.
 * 2. bfs를 이용해서 먹을 수 있는 물고기가 있는지 찾는다.
 * 		2-1) 이때, 0 혹은 자신과 같은 크기의 물고기인 경우에만 움직일 수 있다.
 * 		2-2) 물고기를 먹을때까지 걸리는 시간을 반환한다.
 * 3. 더 이상 먹을 수 있는 물고기가 없다면, 종료! (visited가 모두 true이거나, 남은 물고기가 없는 경우...)
 * ** PriorityQueue를 사용한다. 
 * 		-> 같은 거리에 먹을 수 있는 물고기가 여러마리일 경우를 처리하기 위함.
 */

public class Main_16236 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int baby = 2;
	static int fish = 0;
	static int eatenfish=0;
	static int time = 0;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int sr, sc;
	
	
	public static class shark implements Comparable<shark>{
		int r, c, t;

		public shark(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public int compareTo(shark o) {
			if(this.t == o.t) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.t, o.t);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		sr = 0;
		sc = 0;
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sr = i;
					sc = j;	// 아기 상어의 시작 위치
				}
				else if(map[i][j] != 0) {
					fish++;	// 물고기 개수 표시
				}
			}
		}	

		while(true) {
			// 다음으로 먹을 수 있는 물고기를 향해서 이동이동
			int t = bfs(sr, sc);
			// 만약 먹을 수 있는 물고기가 없다면 반복문 중지
			if(t == 0) {
				break;
			}
			//System.out.println("time = "+ t);
			time += t;
			//System.out.println("total time = "+time);
			// 물고기 먹으면++
			eatenfish++;
			// 물고기를 아기상어의 크기만큼 먹었을 경우 아기 상어가 커진다.
			if(eatenfish == baby) {
				baby++;
				eatenfish=0;
				//System.out.println("babay: "+baby);
			}
			//System.out.println("------------------------------");
		}
		
		System.out.println(time);
		
	}

	private static int bfs(int cr, int cc) {
		PriorityQueue<shark> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		map[cr][cc] = 0;
		pq.add(new shark(cr, cc, 0));
		visited[cr][cc] = true;
		
		
		while(!pq.isEmpty()) {
			shark s = pq.poll();
			int t = s.t;
			
			if(map[s.r][s.c] != 0 && map[s.r][s.c] <baby) {
				map[s.r][s.c]= 9; 
				sr = s.r;
				sc = s.c;
				//print();
				return t;
			}
			
			for(int d=0; d<4; d++) {
				int nr = s.r+dr[d];
				int nc = s.c+dc[d];
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] <= baby) {
					pq.add(new shark(nr, nc, t+1));
					visited[nr][nc] = true;
				}
			}
			
		}
		
		return 0;
	}

	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
