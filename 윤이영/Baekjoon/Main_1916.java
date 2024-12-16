import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
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
	
	static int N, M;
	static List<Node>[] adjList;
	static int[] cost;
	static int start, end;
	static int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 도시
		M = Integer.parseInt(br.readLine());	// 버스
		
		adjList = new ArrayList[N+1];
		cost = new int[N+1];
		// 인접리스트 초기화
		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		Arrays.fill(cost, INF);
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[s].add(new Node(e, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(cost[end]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		cost[start] = 0;
		que.add(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			if(visited[cur.v]) continue; // 이미 방문했다면 패스
			
			visited[cur.v]= true;
			for(Node node: adjList[cur.v]) {
				if(!visited[node.v] && cost[node.v] > cost[cur.v] + node.w ) {
					cost[node.v] = cost[cur.v]+node.w;
					que.add(new Node(node.v, cost[node.v]));
				}
			}
		}
		
	}
}
