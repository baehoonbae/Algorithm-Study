package class3;

import java.io.*;
import java.util.*;

public class Boj_10026_적록색약 {

    static int N, section, sectionDiff, sectionSame;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static char color;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        section = 1;

        for(int i = 0; i < N; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = c[j];
            }
        }

        color = map[0][0];
        bfs(0, 0, color);
        sectionDiff = section;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        color = map[0][0];
        visited = new boolean[N][N];
        section = 1;
        bfs(0, 0, color);
        sectionSame = section;


        System.out.println(sectionDiff + " " + sectionSame);

    }

    private static void bfs(int sr, int sc, char scolor) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {sr, sc, scolor});
        visited[sr][sc] = true;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int color = cur[2];
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == color) {
                    que.offer(new int[] {nr, nc, color});
                    visited[nr][nc] = true;
                }
            }
        }

        boolean jud = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if(!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    section++;
                    jud = true;
                    break;
                }
            }
            if(jud) break;
        }
    }

    private static boolean check(int r, int c) {
        return  r >= 0 && r < N && c >= 0 && c < N;
    }
}
