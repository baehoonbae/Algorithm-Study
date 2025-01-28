import java.io.*;
import java.util.*;

public class Main_1325 {
	static LinkedList<Integer>[] graph;
	static int N, M;
	static int[] count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new LinkedList[N + 1];
		count = new int[N + 1];

		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}

		int max = 0;
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			count[i] = dfs(i);
			max = Math.max(max, count[i]);
		}

		for(int i = 1; i <= N; i++) {
			if(count[i] == max) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}

	static int dfs(int node) {
		visited[node] = true;
		int cnt = 1;

		for(int next : graph[node]) {
			if(!visited[next]) {
				cnt += dfs(next);
			}
		}
		return cnt;
	}
}