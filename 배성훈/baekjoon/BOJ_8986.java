import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8986. 전봇대 / 플래티넘 5 / 44분
2차그래프 극솟값찾기
삼분탐색
 */
public class BOJ_8986 {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        long left=1;
        long right=(long)1e+9+1;
        while(right-left>=3) {
            long mid1=left+(right-left)/3;
            long mid2=right-(right-left)/3;
            long r1=function(mid1);
            long r2=function(mid2);

            if(r1<=r2) {
                right=mid2;
            } else {
                left=mid1;
            }
        }
        long min=Long.MAX_VALUE;
        for(long i=left;i<=right;i++){
            min=Math.min(min,function(i));
        }
        System.out.println(min);
    }

    private static long function(long x){
        long total=0;
        long mul=0;
        for(int i=1;i<n;i++){
            mul+=x;
            total+=Math.abs(mul-arr[i]);
        }
        return total;
    }
}