import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] campus;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];
        result = 0;
        
        int sr = 0;
        int sc = 0;
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);

                if(campus[i][j] == 'I') {
                    sr = i;
                    sc = j;
                    
                }
            }
        }

        bfs(sr, sc);
        System.out.println(result == 0 ? "TT" : result);
    }

    static void bfs(int sr, int sc) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while(!que.isEmpty()) {
            int[] arr = que.poll();

            for(int d = 0; d < 4; d++) {
                int nr = arr[0] + drc[d][0];
                int nc = arr[1] + drc[d][1];

                if(!check(nr, nc) || visited[nr][nc] || campus[nr][nc] == 'X') continue;

                if(campus[nr][nc] == 'P') result++;

                que.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
