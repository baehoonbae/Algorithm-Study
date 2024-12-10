import java.io.*;
import java.util.*;

public class Main_14888 {

    static int N, max, min;
    static int[] nums, cal;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        cal = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx) {

        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] == 0) continue;
            cal[i]--;
            if (i == 0) {
                dfs(num + nums[idx], idx + 1);
            }else if (i == 1) {
                dfs(num - nums[idx], idx + 1);
            }else if (i == 2) {
                dfs(num * nums[idx], idx + 1);
            }else if (i == 3) {
                dfs(num / nums[idx], idx + 1);
            }
            cal[i]++;
        }

    }

}