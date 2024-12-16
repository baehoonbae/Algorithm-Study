import java.util.Scanner;

public class Main_1058 {
    static int N;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dist = new int[N][N];

        // 초기화
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'Y') {
                    dist[i][j] = 1; // 친구 관계는 거리 1
                } else if (i != j) {
                    dist[i][j] = 1000000000; // 친구가 아니면 큰 값으로 초기화
                }
            }
        }

        // 플로이드 와샬
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 2-친구 계산
        int maxFriends = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && dist[i][j] <= 2) {
                    count++;
                }
            }
            maxFriends = Math.max(maxFriends, count);
        }

        // 결과 출력
        System.out.println(maxFriends);
    }
}
