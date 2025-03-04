import java.util.Scanner;

public class Solution_1288 {
    static int T, N;
    static int total = (1 << 10) -1;    // 모든 숫자가 등장했을 떄의 값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        // 테스트케이스만큼 반복
        for(int tc=1; tc<=T; tc++){
            N = sc.nextInt();
            int visited = 0;
            int cnt;

            for(cnt = 1; ; cnt++){
                char[] arr = String.valueOf(N * cnt).toCharArray();
                for(char c: arr){
                    int num = c -'0';
                    visited = visited | (1 << num); // 해당 숫자 등장을 비트마스킹으로 표현
                }

                if(visited == total) break; // 모든 숫자가 등장한 경우
            }
            System.out.println("#"+tc+" "+ N * cnt);
        }
    }
}
