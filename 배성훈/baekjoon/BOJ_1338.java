package baekjoon;

import java.util.*;

public class BOJ_1338 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long l=sc.nextLong();
        long r=sc.nextLong();
        long x=sc.nextLong();
        long y=sc.nextLong();
        x=Math.abs(x);
        if(l>r) {
            long temp=l;
            l=r;
            r=temp;
        }

        if(r-l>=2*x||!(0<=y&&y<x)){
            System.out.println("Unknwon Number");
            return;
        }

        int count=0;
        ArrayList<Long> list=new ArrayList<>();
        long st=l;

        if((((l%x)+x)%x)!=y){
            if((((l%x)+x)%x)<=y){
                st+=y-(((l%x)+x)%x);
            } else {
                st+=x-(((l%x)+x)%x)+y;
            }
        }

        for(long i=st;i<=r;i+=x){
            if((((i%x)+x)%x)==y){
                count++;
            }
            if(count>1){
                System.out.println("Unknwon Number");
                return;
            }
        }

        if(count==0){
            System.out.println("Unknwon Number");
        } else {
            System.out.println(st);
        }
    }
}