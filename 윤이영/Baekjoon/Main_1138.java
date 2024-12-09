import java.util.Scanner;

public class Main_1138 {
	static int N;
	static int[] order;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		order = new int[N];
		arr = new int[N];
		for(int i=0; i<N; i++) {
			order[i] = sc.nextInt();
		}
		
		
		 // 키 순서로 배치
        for (int i = 0; i < N; i++) {
            int count = order[i]; // 자신보다 키가 큰 사람의 수
            
            for (int j = 0; j < N; j++) {
                // 현재 위치가 비어 있고, 키 큰 사람 수만큼 건너왔다면 배치
                if (arr[j] == 0 && count == 0) {
                    arr[j] = i + 1; 
                    break;
                } else if (arr[j] == 0) {
                    count--; 
                }
            }
        }
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
