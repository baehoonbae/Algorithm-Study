import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static boolean[] visited;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++){
            int s = roads[i][0];
            int e = roads[i][1];
            graph[s].add(e);
            graph[e].add(s);
        }
        Arrays.fill(dist, -1);
        BFS(destination);
        
        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    public static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;
        visited[start] = true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int next: graph[cur]){
                if(visited[next]) continue;
                dist[next] = dist[cur]+1;
                visited[next] = true;
                que.add(next);
            }
        }
        
    }
    
    
}
