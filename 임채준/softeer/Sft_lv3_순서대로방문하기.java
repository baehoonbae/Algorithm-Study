package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_순서대로방문하기 {

    static int n, m, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[][] points;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        points = new int[m][2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            points[i][0] = r;
            points[i][1] = c;
        }

        visited = new boolean[n][n];
        dfs(points[0][0], points[0][1], 0);

        System.out.println(ans);
    }

    public static void dfs(int r, int c, int idx){
        if (r < 0 || r >= n || c < 0 || c >= n) return;
        if (map[r][c] == 1 || visited[r][c]) return;

        if (r == points[idx][0] && c == points[idx][1]) {
            idx++;
            if (idx == m) {
                ans++;
                return;
            }
        }

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            dfs(nr, nc, idx);
        }

        visited[r][c] = false;
    }
}
