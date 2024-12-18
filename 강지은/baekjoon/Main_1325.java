import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325 {
	
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] count;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
        
        count = new int[N];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			
			adj[B].add(A);
		}
        
        int max = 0;
        for (int i = 0; i < N; i++) {
			count[i] = bfs(i);
			max = Math.max(max, count[i]);
		}
        
        for (int i = 0; i < N; i++) {
			if (count[i]==max) {
				System.out.print(i+1+" ");
			}
		}
        
    }

	private static int bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		visit = new boolean[N];
		
		que.add(start);
		visit[start] = true;
		
		int count = 1;
		while (!que.isEmpty()) {
			int cur = que.poll();
			
			for (int i = 0; i < adj[cur].size(); i++) {
				int next = adj[cur].get(i);
				
				if (visit[next]) continue;
				que.add(next);
				visit[next] = true;
				count++;
			}
		}
		
		return count;
	}

    
}
