import java.util.Scanner;

public class Main_1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next(); // 입력 문자열
        
        int index = 0; // 입력 문자열에서 현재 검사 중인 위치
        int num = 1; // 현재 검사 중인 숫자
        
        while (index < s.length()) {
            String current = Integer.toString(num); // 숫자를 문자열로 변환
            
            for (int i = 0; i < current.length() && index < s.length(); i++) {
                if (current.charAt(i) == s.charAt(index)) {
                    index++; // 입력 문자열에서 다음 문자로 이동
                }
            }
            num++; // 다음 숫자로 이동
        }
        
        System.out.println(num - 1); // 마지막으로 검사한 숫자를 출력
    }
}
