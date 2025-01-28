import java.util.*;
import java.io.*;

// 각 자리수의 합이 3의 배수면 가능
public class Main10610_30 {
    static String N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = br.readLine();

        char[] ch = N.toCharArray();
        Arrays.sort(ch);

        int result = 0;
        for(int i = N.length()-1; i >= 0; i--) {
            result += ch[i] - '0';
            sb.append(ch[i]-'0');
        }

        if(result % 3 != 0 || ch[0] != '0') {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());

    }
}
