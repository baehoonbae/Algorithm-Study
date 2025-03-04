import java.util.Scanner;

public class Main_12933 {
    static int ans =0;
    static boolean[] visited;
    static boolean check;
    static char[] duck = {'q','u','a','c','k'};
    static int[] cnt = new int[5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        visited = new boolean[str.length];

        int start = 0;

        while(start < str.length){
            check = false;
            if(!visited[start] && duck[0] == str[start]){
                int i;
                int j=0;
                for(i=start; i<str.length; i++){
                    if(!visited[i] && str[i] == duck[j]){
                        visited[i] = true;
                        cnt[j]++;
                        j++;
                        if(j == 5){
                            check = true;
                            j = 0;
                        }

                    }
                }
                if(check && j == 0){
                    ans++;
                }
            }
            start++;
        }

        for (boolean b : visited) {
            if (!b) {
                ans = -1;
                break;
            }
        }
        // q가 여러개 있을 경우
        for(int i: cnt){
            if(i != visited.length/5){
                ans = -1;
                break;
            }
        }

        if(ans == 0) ans = -1;

        System.out.println(ans);

    }
}
