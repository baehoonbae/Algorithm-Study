import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {
	static int N, M, X;
	static List<Node>[] list; // X가 출발점일 때
	static List<Node>[] rlist; // X가 종점일 때
	static int INF = 987654321;
	static int[] time, rtime;
	
	static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// N명의 학생
		M = Integer.parseInt(st.nextToken());	// M개의 도로
		X = Integer.parseInt(st.nextToken());	// 파티 장소
		
		
		list = new ArrayList[N+1];
		rlist = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
			rlist[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(e, t));
			rlist[e].add(new Node(s, t));	// 역방향
		}
		
		time = dijkstra(X, list);
		rtime = dijkstra(X, rlist);
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, time[i]+rtime[i]);
		}
		
		System.out.println(max);
		
	}

	private static int[] dijkstra(int start, List<Node>[] adjlist) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		que.add(new Node(start, 0));

		while(!que.isEmpty()) {
			Node cur = que.poll();
			if(visited[cur.v]) continue;
			visited[cur.v] = true;
			
			for(Node n: adjlist[cur.v]) {
				if(!visited[n.v] && dist[n.v] > dist[cur.v]+ n.w) {
					dist[n.v]= dist[cur.v]+n.w;
					que.add(new Node(n.v, dist[n.v]));
				}
			}
		}
		
		
		return dist;
	}
}

/*
 * 일반적으로 다익스트라는 출발점을 주지만, 이 문제에서는 출발점인 경우 + 도착점인 경우를 모두 찾아야 함.
 * 도착점인 경우에는 역방향 그래프를 사용해서 X를 출발점으로 바꿔준다.
 * 1. 일반적인 접근 방식
	모든 정점에서 도착점까지 최단 경로를 구하기 위해, 각 정점에서 다익스트라를 수행해야 함.
	예를 들어, 정점 A에서 도착점 X로 가기 위한 최단 경로를 계산하려면, 시작점을 A로 설정하고 다익스트라를 수행해야 함.
	2. 역방향 그래프를 사용하는 접근 방식
	역방향 그래프를 생성하고, 도착점 X를 시작점으로 다익스트라를 한 번만 수행.
	역방향 그래프에서 도착점 X를 시작점으로 다익스트라를 수행하면, 원래 그래프의 각 정점에서 도착점으로의 최단 경로를 한 번에 구할 수 있음.
 */
