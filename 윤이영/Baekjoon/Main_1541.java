import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541 {
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String S = br.readLine();
        // "-" 문자를 기준으로 나눈다.
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int idx = 0;
        while(st.hasMoreTokens()){
            int temp = 0;
            // "+" 문자를 기준으로 나누고, temp로 더한다.
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while(st2.hasMoreTokens()){
                temp += Integer.parseInt(st2.nextToken());
            }

            if(idx == 0){
                ans += temp;
            }else{
                ans -= temp;
            }
            idx++;
        }

        System.out.println(ans);
    }
}
