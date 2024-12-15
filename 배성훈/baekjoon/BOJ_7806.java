import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
7806. GCD! / 골드 3 / 41분
 */
class BOJ_7806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int MAX=1_000_000_000;
        final int SQRT_MAX=(int)Math.sqrt(MAX);

        boolean[] sieve=new boolean[SQRT_MAX+1];
        List<Integer>primes=new ArrayList<>();
        Arrays.fill(sieve,true);
        /*
        gcd(a!, b)를 구하는 문제
        b를 소인수분해하고
        각소인수가얼만큼나오는지 확인하고
        a!에서 그 수가 얼마나나오는지 나눠본다
        최대공약수는 b의소인수의 거듭제곱과 a!에서 얼마나나온지 나눠본수중에 최솟값만큼 해당 소수를거듭제곱한 결과들을 곱한수가된다
        */

        // 에라토스 전처리
        sieve[0]=sieve[1]=false;
        for(int i=2;i*i<=SQRT_MAX;i++){
            if(sieve[i]){
                for(int j=i*i;j<=SQRT_MAX;j+=i){
                    sieve[j]=false;
                }
            }
        }
        for(int i=2;i<=SQRT_MAX;i++){
            if(sieve[i])primes.add(i);
        }
        while(true){
            String s=br.readLine();
            if(s==null||s.trim().isEmpty())return;

            st=new StringTokenizer(s);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            Map<Integer,Integer> soinsu=new HashMap<>();

            for(int i:primes){
                if(i>b)break;
                while(b%i==0){
                    soinsu.merge(i,1,Integer::sum);
                    b/=i;
                }
            }
            if(b>1)soinsu.merge(b,1,Integer::sum);
            int ans=1;
            for(int i:soinsu.keySet()){
                int num=0;
                int share=i;
                while(share<=a){
                    num+=a/share;
                    if(share>a/i)break;
                    share*=i;
                }
                ans*=(int)Math.pow(i,Math.min(soinsu.get(i),num));
            }
            System.out.println(ans);
        }
    }
}