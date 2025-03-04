import java.util.Scanner;
/*
    S => T 로 변환하는 방법으로 탐색하지 말고,
    T => S 로 변환하면 시간초과 문제를 해결할 수 있다.
 */
public class Main_12919 {
    static String S, T;
    static int check = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();

        dfs(T);
        System.out.println(check);
    }

    private static void dfs(String tmp) {
        if(tmp.length() < S.length()) return;
        if(tmp.equals(S)){
            check = 1;
            return;
        }

        // 문자열의 맨 뒤 문자가 'A'라면 'A' 제거
        if(tmp.charAt(tmp.length()-1) == 'A'){
            dfs(tmp.substring(0, tmp.length()-1));
        }
        // 첫 글자가 'B'라면 뒤집고 맨 뒷글자 'B' 제거
        if(tmp.charAt(0) == 'B'){
            String reverse = new StringBuilder(tmp).reverse().toString();
            dfs(reverse.substring(0, reverse.length()-1));
        }
    }
}
