import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21608 {
	static int N;
	static int[][] map;
	static int[][] like;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int totallike = 0;
	static int[] favnum = {0, 1, 10, 100, 1000};
	
	//1. 좋아하는 학생이 가장 많은 칸
	//2. 주변에 비어있는 칸이 가장 많은 자리
	//3. 행의 번호가 가장 적은 칸, 
	//4. 열의 번호가 가장 작은 칸
	static class Seat implements Comparable<Seat>{
		int r, c, like;
		int empty;
		public Seat(int r, int c, int empty, int like) {
			super();
			this.r = r;
			this.c = c;
			this.empty = empty;
			this.like = like;
		}
		@Override
		public int compareTo(Seat o) {
			if(this.like==o.like) {
				if(this.empty == o.empty) {
					if(this.r == o.r) {
						return Integer.compare(o.c, this.c);
					}
					return Integer.compare(o.r, this.r);
				}
				return Integer.compare(o.empty, this.empty);
			}
			return Integer.compare(o.like, this.like);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		like = new int[N*N][5];
		
		// 좋아하는 학생들을 조사
		for(int i=0; i<(N*N); i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//System.out.println(i);
			for(int j=0; j<5; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 자리에 앉히기
		//map[1][1] = like[0][0];	// 첫번쨰 학생은 무조건 1,1 자리에 앉게 됨.
		//	1. 한명씩 좋아하는 학생이 가장 많은 칸에 넣는다.
		for(int i=0; i<N*N; i++) {
			findfav(like[i]);
		}
		
		// 총 만족도 조사하기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {

				int n = map[r][c];
				int[] temp;
				for(int i=0; i<N*N; i++) {
					if(like[i][0] == n) {
						totallike += gettotallike(like[i], r, c);
					}
				}

			}
		}
		
		System.out.println(totallike);

	}

	private static int gettotallike(int[] like, int r, int c) {
		int l = 0;
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc)) continue;
			for(int i=1; i<5; i++) {
				if(map[nr][nc] == like[i]) l++;
			}
		}
		int sum = favnum[l];
		return sum;
	}

	private static void findfav(int[] like) {
		PriorityQueue<Seat> pq = new PriorityQueue<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 0) {
					int l = 0;
					int e = 0;
					
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						if(!check(nr, nc)) continue;
						if(map[nr][nc] == 0) e++;
						for(int i=1; i<5; i++) {
							if(map[nr][nc] == like[i]) l++;
						}
					}
					
					pq.add(new Seat(r, c, e, l));
				}
			}
		}
		
		Seat s = pq.poll();
		map[s.r][s.c]= like[0]; 

	}

	private static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r>=0 && r<N && c>=0 && c<N;
	}
}
