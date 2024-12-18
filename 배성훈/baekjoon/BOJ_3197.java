import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3197. 백조의 호수 / 플래5 / 2일
// 큐 5개 이용
// sq1: 첫번째 백조 이동 큐
// sq2: 두번째 백조 이동 큐
// wq1: 첫번째 백조가 발견한 물이 될 빙판
// wq2: 두번째 백조가 발견한 물이 될 빙판
// wq3: 백조들이 발견하지 못한 물과 맞닿아 있던 물이 될 빙판
// 초기화할 때 물에 원래 맞닿아있던 빙판들은 wq3에 넣고 시작
// 두 백조가 빙판 만날 때까지 전진
// 빙판 만나면 빙판들을 wq1, wq2에 넣고 녹인다(play 메서드)
// 빙판 녹이고 각 위치를 sq1, sq2에 넣는다(백조의 다음 위치)
// 두 백조가 만나는 구간에서 time 출력
public class BOJ_3197 {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static char[][] arr;
    static Queue<int[]> sq1, sq2, wq1, wq2, wq3;
    static boolean[][] sv1, sv2;

    public static void main(String[] args) throws IOException {
        init();
        int time = 0;
        while (true) {
            if (search()) {
                break;
            }
            play();
            time++;
        }
        System.out.println(time);
    }

    // 백조가 나아가는 bfs
    // 빙판 발견하면 거기서 멈추고 그 빙판은 물이 될 애들이니 wq 에 넣어줌
    private static boolean search() {
        while (!sq1.isEmpty() || !sq2.isEmpty()) {
            for (int q = 0; q < sq1.size(); q++) {
                int[] pos = sq1.poll();
                int y = pos[0];
                int x = pos[1];
                if (sv2[y][x]) {
                    return true;
                }
                sv1[y][x] = true;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || sv1[ny][nx]) {
                        continue;
                    }
                    sv1[ny][nx] = true;
                    if (arr[ny][nx] == '.') {
                        sq1.add(new int[]{ny, nx});
                    } else {
                        wq1.add(new int[]{ny, nx,});
                    }
                }
            }
            for (int q = 0; q < sq2.size(); q++) {
                int[] pos = sq2.poll();
                int y = pos[0];
                int x = pos[1];
                if (sv1[y][x]) {
                    return true;
                }
                sv2[y][x] = true;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || sv2[ny][nx]) {
                        continue;
                    }
                    sv2[ny][nx] = true;
                    if (arr[ny][nx] == '.') {
                        sq2.add(new int[]{ny, nx});
                    } else {
                        wq2.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return false;
    }

    private static void play() {
        int size1 = wq1.size();
        int size2 = wq2.size();
        int size3 = wq3.size();
        for (int q = 0; q < size1; q++) {
            int[] pos = wq1.poll();
            int y = pos[0];
            int x = pos[1];
            arr[y][x] = '.';
            sq1.add(new int[]{y, x});
        }
        for (int q = 0; q < size2; q++) {
            int[] pos = wq2.poll();
            int y = pos[0];
            int x = pos[1];
            arr[y][x] = '.';
            sq2.add(new int[]{y, x});
        }
        for (int q = 0; q < size3; q++) {
            int[] pos = wq3.poll();
            int y = pos[0];
            int x = pos[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] == '.') {
                    continue;
                }
                arr[ny][nx] = '.';
                wq3.add(new int[]{ny, nx});
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        sq1 = new LinkedList<>();
        sq2 = new LinkedList<>();
        wq1 = new LinkedList<>();
        wq2 = new LinkedList<>();
        wq3 = new LinkedList<>();
        sv1 = new boolean[n][m];
        sv2 = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'L') {
                    arr[i][j] = '.';
                    if (sq1.isEmpty()) {
                        sq1.add(new int[]{i, j});
                    } else {
                        sq2.add(new int[]{i, j});
                    }
                    wq3.add(new int[]{i, j});
                } else if (arr[i][j] == '.') {
                    wq3.add(new int[]{i, j});
                }
            }
        }
    }
}