import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1254_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        for(int i = 0; i < str.length(); i++) {
            if(check(str.substring(i))) {
                break;
            }
            len++;
        }
        System.out.println(len);
    }

    static boolean check(String str) {
        int start = 0;
        int last = str.length() - 1;
        while(start <= last) {
            if(str.charAt(start) != str.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }

        return true;
    }
}
