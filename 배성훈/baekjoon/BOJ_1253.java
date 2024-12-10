import java.io.IOException;
import java.util.Arrays;


// 1253. 좋다 / 골드 4 / 54분
class BOJ_1253 extends FI1 {
    public static void main(String[] args) throws IOException {
        initFI();
        int n=nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=nextLong();
        }
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<n;i++) {
            long target=arr[i];
            int left=0;
            int right=n - 1;

            while(left<right) {
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                long sum=arr[left]+ arr[right];
                if(sum==target) {
                    count++;
                    break;
                } else if(sum<target) {
                    left++;
                } else{
                    right--;
                }
            }
        }
        System.out.println(count);
    }
}