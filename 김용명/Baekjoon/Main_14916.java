import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(true) {
			if(n%5 == 0) {
				count += n/5;
				System.out.println(count);
				break;
			}else {
				n -=2;
				count++;
			}
			if(n<0) {
				System.out.println(-1);
				break;
			}
		}	
	}
}
