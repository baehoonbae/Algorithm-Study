import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
11066. 파일 합치기 / 골드 3 / 47분
dp
 */
public class BOJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            int K=Integer.parseInt(br.readLine());
            int[] sizes=new int[K];
            st=new StringTokenizer(br.readLine());
            for (int i=0;i<K;i++) {
                sizes[i]=Integer.parseInt(st.nextToken());
            }
            int[][] dp=new int[K][K];
            int[] prefs=new int[K];
            prefs[0]=sizes[0];

            for (int i=1;i<K;i++) {
                prefs[i]=prefs[i-1]+sizes[i];
            }

            //dp[i][j]=> i부터j까지 합치는 최소비용
            // len은 범위를 설정하는 변수
            //바텀업으로 구하기
            // 만약 3개를 합친다면?
            // [0][2] => min([0][2], min( [0][0]+[1][2], [0][1]+[2][2] ))
            for (int len=2;len<=K;len++) {
                for (int i=0;i<=K-len;i++) {
                    int j=i+len-1;
                    dp[i][j]=Integer.MAX_VALUE;
                    for (int k=i;k<j;k++) {
                        dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+getSum(prefs,i,j));
                    }
                }
            }
            System.out.println(dp[0][K-1]);
        }
    }

    private static int getSum(int[] prefs,int i,int j) {
        if(i==0) return prefs[j];
        return prefs[j]-prefs[i-1];
    }
}