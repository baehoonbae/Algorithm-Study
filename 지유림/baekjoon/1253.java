import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1253_좋다 {
    static int N;
    static long[] nums;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new long[N];
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        for(int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            long num = nums[i];

            while(left < right) {
                if(nums[left] + nums[right] == num) {
                    if(left != i && right != i) {
                        count++;
                        break;
                    } else if(left == i) {
                        left++;
                    } else if(right == i) {
                        right--;
                    }
                } else if(nums[left] + nums[right] < num) {
                    left++;
                } else if(nums[left] + nums[right] > num) {
                    right--;
                }
            }
        }
        System.out.println(count);
    }
}
