package baekjoon;

import java.util.*;

public class BOJ_1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int count=0;
        int digit=1;
        while(Integer.bitCount(n)>k){
            if(n%2!=0){
                count+=digit;
                n++;
            }
            n/=2;
            digit*=2;
        }
        System.out.println(count);
    }
}
