import java.io.IOException;

// 1557. 제곱 ㄴㄴ / 다이아몬드 5 / 3시간
public class BOJ_1557 extends FI1 {
    static final int N=111111;
    static int[] sieve=new int[N];
    public static void main(String[] args) throws IOException {
        initFI();
        init();
        long k=nextLong();
        long left=0,right=(long)1e10;

        while(left<right-1){
            long x=(left+right)/2;
            if(play(x)<k){
                left=x;
            }else{
                right=x;
            }
        }
        System.out.println(right);
    }

    /*
    포함배제의원리로 곱해지는 인수의 개수가 홀수면 합집합개수에 더하고 짝수면 합집합개수에서뺀다
    뫼비우스함수도 비슷한데 얘는 소수의 개수에 따라 -1,1,0 값을가짐
    2,3,5,7... 소수들은 -1
    이외에 애들은 1, 그리고 제곱수의 배수들은 0이된다
    0이 아닌애들은
    특이사항으로는 공배수로취급되는애들(6,30....)은 소수의 뫼비우스함수 값을 통해 계속 토글된다
     */
    private static void init() {
        sieve[1]=1;
        for (int i=1;i<N;i++) {
            for (int j=i*2;j<N;j+=i) {
                sieve[j]-=sieve[i];
            }
        }
    }

    private static long play(long x) {
        long cnt=0;

        // i를 1부터 시작하여 i*i가 n보다 작거나 같은 동안 반복
        for (long i=1;i*i<=x;i++) {
            // i*i로 나누어지는 수의 개수를 계산하고, 뫼비우스 함수 값을 곱하여 cnt에 더함
            // sieve[i]는 i에 대한 뫼비우스 함수 값
            // n / (i * i)는 n 이하의 i*i의 배수의 개수
            // 뫼비우스함수 값이 -1이라면 얘는 현재값 x라는 범위에 대해 공배수취급받고있다는거임(배제시켜야하는 애)
            cnt+=sieve[(int)i] * (x/(i*i));
        }
        return cnt;
    }
}