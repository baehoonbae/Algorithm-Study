package baekjoon;

import java.util.Scanner;

public class BOJ_15988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        long[] dp=new long[1111111];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=1000000;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1_000_000_009;
        }
        while(t-->0){
            int n=sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
