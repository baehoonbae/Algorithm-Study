import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20922 {
    static int N, K;
    static int[] arr, cnt;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cnt = new int[200001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int len = 0;
        for(int r=0; r<N; r++){
            cnt[arr[r]]++;  // cnt 이상이면 증가
            while(cnt[arr[r]] > K && l <r){
                cnt[arr[l]]--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            len++;
        }

        System.out.println(ans);
    }
}
