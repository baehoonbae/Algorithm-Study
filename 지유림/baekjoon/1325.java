import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] count;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열로 초기화하여 접근 속도 향상
        graph = new ArrayList[N + 1];
        count = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 방향을 반대로 저장 (신뢰받는 쪽 -> 신뢰하는 쪽)
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);  // 방향 반대로 저장
        }

        // 각 노드에서 BFS 실행
        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        // 최댓값 찾기
        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, count[i]);
        }

        // 결과 출력
        for(int i = 1; i <= N; i++) {
            if(count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        count[start]++;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count[start]++;
                }
            }
        }
    }
}
