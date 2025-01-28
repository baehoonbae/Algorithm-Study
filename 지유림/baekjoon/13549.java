import java.io.*;
import java.util.*;

public class Main13549_숨바꼭질3 {
    static int N, K;
    static boolean[] visited;
    static int result;
    static class Point {
        int position, time;

        public Point(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
    static int max = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        result = Integer.MAX_VALUE;
        bfs();
        System.out.println(result);
    }

    static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(N, 0));

        while(!que.isEmpty()) {
            Point p = que.poll();
            int position = p.position;
            int time = p.time;

            visited[position] = true;

            if(position == K) {
                result = Math.min(result, time);
            }

            if(position*2 <= max && !visited[position*2]) {
                que.offer(new Point(position*2, time));
            }

            if(position+1 <= max && !visited[position+1]) {
                que.offer(new Point(position+1, time+1));
            }

            if(position-1 >= 0 && !visited[position-1]) {
                que.offer(new Point(position-1, time+1));
            }
        }
    }
}
