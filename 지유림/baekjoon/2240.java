import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int T, W;
    static int[] tree;
    static int[][][] dp; // [현재위치][시간][이동횟수]
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        tree = new int[T+1];
        for(int t = 1; t <= T; t++) {
            tree[t] = Integer.parseInt(br.readLine());
        }

         dp = new int[3][T + 1][W + 2];  
        
        // 초기상태 처리 (첫 번째 자두)
        if (tree[1] == 1) {
            dp[1][1][0] = 1;  // 1번 나무 위치에서 시작, 이동 없음, 자두 받음
        } else {
            dp[2][1][1] = 1;  // 2번 나무 위치로 이동, 이동 1번, 자두 받음
        }
        
        for(int i = 2; i <= T; i++) {      // 시간 (2부터 시작)
            for(int j = 0; j <= W; j++) {  // 이동 횟수 (0부터 시작)
                // 이동 횟수가 0인 경우는 항상 1번 나무에 있는 경우
                if (j == 0) {
                    if (tree[i] == 1) {
                        dp[1][i][0] = dp[1][i-1][0] + 1;
                    } else {
                        dp[1][i][0] = dp[1][i-1][0];
                    }
                    continue;
                }
                
                if(tree[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]) + 1;
                    dp[2][i][j] = Math.max(dp[1][i-1][j-1], dp[2][i-1][j]);
                } else {
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
                    dp[2][i][j] = Math.max(dp[1][i-1][j-1], dp[2][i-1][j]) + 1;
                }
            }
        }

        int result = 0;
        for(int i = 0; i <= W; i++) {  
            result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(result);
        
    }
}
