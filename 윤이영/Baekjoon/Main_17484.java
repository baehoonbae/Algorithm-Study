import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17484 {
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static int[] dc = {-1, 0, 1}; // 방향 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3]; // 방향 3개를 추적

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 줄 초기화
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                dp[0][c][d] = map[0][c]; // 첫 줄은 이동 방향 제한 없음
            }
        }

        // DP 계산
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < 3; d++) {
                    dp[r][c][d] = Integer.MAX_VALUE-1000; 

                    int prevCol = c - dc[d];
                    if (prevCol >= 0 && prevCol < M) {
                        for (int prevD = 0; prevD < 3; prevD++) {
                            if (prevD != d) { // 직전 방향과 다른 방향만 고려
                                dp[r][c][d] = Math.min(dp[r][c][d], dp[r - 1][prevCol][prevD] + map[r][c]);
                            }
                        }
                    }
                }
            }
        }

        // 최종 결과 계산
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                ans = Math.min(ans, dp[N - 1][c][d]);
            }
        }

        System.out.println(ans);
    }
}
