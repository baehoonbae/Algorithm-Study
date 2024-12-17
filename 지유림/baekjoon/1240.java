import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int w;
        
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    static ArrayList<Node>[] graph;
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 트리 정보 입력
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            // 양방향으로 저장
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }
        
        // 거리를 알고 싶은 노드 쌍 처리
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            sb.append(getDistance(start, end)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    // BFS로 두 노드 사이의 거리 찾기
    static int getDistance(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        int[] distances = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(distances, -1);
        distances[start] = 0;
        visited[start] = true;
        queue.add(new Node(start, 0));
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if(curr.v == end) {
                return distances[end];
            }
            
            for(Node next : graph[curr.v]) {
                if(!visited[next.v]) {
                    visited[next.v] = true;
                    distances[next.v] = distances[curr.v] + next.w;
                    queue.add(new Node(next.v, distances[next.v]));
                }
            }
        }
        
        return -1;
    }
}
