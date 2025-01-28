import java.io.*;
import java.util.*;

public class Main17836_공주님을구해라 {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Point {
        int r, c, sword, time;

        Point(int r, int c, int sword, int time) {
            this.r = r;
            this.c = c;
            this.sword = sword;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int result = bfs();
        if(result == -1) System.out.println("Fail");
        else System.out.println(result);

    }

    static int bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!que.isEmpty()) {
            Point p = que.poll();

            if(p.r == N-1 && p.c == M-1 && p.time <= T) {

                return p.time;
            }

            for(int d = 0; d < 4; d++) {
                int nr = p.r + drc[d][0];
                int nc = p.c + drc[d][1];

                if(!check(nr, nc) || visited[nr][nc][p.sword]) continue;
                if(map[nr][nc] == 1 && p.sword > 0) { // 벽이고 검이 있으면
                    que.offer(new Point(nr, nc, p.sword, p.time+1));
                    visited[nr][nc][p.sword] = true;
                } else if(map[nr][nc] == 1 && p.sword == 0) continue;
                else if(map[nr][nc] == 2) {
                    que.offer(new Point(nr, nc, 1, p.time+1));
                    visited[nr][nc][1] = true;
                } else if(map[nr][nc] == 0) {
                    que.offer(new Point(nr, nc, p.sword, p.time+1));
                    visited[nr][nc][p.sword] = true;
                }
            }
        }

        return -1;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
