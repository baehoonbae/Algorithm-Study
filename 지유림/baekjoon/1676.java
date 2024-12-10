import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다 곱해서 하면 터짐;;
// 5*2 등등.. 5의 배수일 때 0이 나오니까 5를 나눠서 그 개수를 체크하자
public class Main1676_팩토리얼0의개수 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int count = 0;
        while(true) {
            if(N < 5) break;

            count += (N/=5);
        }

        System.out.println(count);
    }
}
