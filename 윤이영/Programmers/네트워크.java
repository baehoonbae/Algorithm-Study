import java.util.*;

class Solution {
    static boolean[] visited;
    static Queue<Integer> que = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            BFS(i, computers, n);
            answer++;
            
        }
        
        return answer;
    }
    
    static void BFS(int start, int computers[][], int n){
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i=0; i<n; i++){
                if(visited[i]) continue;
                if(computers[cur][i] == 1){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    } 
    
}
