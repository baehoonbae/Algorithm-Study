import java.util.*;
import java.io.*;


public class Main_Softeer_전광판
{
	static Map<Integer,String> lights = new HashMap<>();
	static int T;
    public static void main(String args[])    {
    	// 전광판 숫자를 미리 저장
        lights.put(0, "1110111");
        lights.put(1, "0010010");
        lights.put(2, "1011101");
        lights.put(3, "1011011");
        lights.put(4, "0111010");
        lights.put(5, "1101011");
        lights.put(6, "1101111");
        lights.put(7, "1110010");
        lights.put(8, "1111111");
        lights.put(9, "1111011");
        lights.put(10, "0000000");
       
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        // 테스트케이스만큼 반복
        for(int i=0; i<T; i++) {
        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	int count = 0;
        	while(true) {
        		int tempA = A %10;
        		int tempB = B % 10;
        		
        		if(A == 0) {
        			tempA = 10;
        		}
        		if(B == 0) {
        			tempB = 10;
        		}
        		//System.out.println(tempA + " " + tempB);
        		count += diff(tempA, tempB);
        		A /= 10;
        		B /= 10;
        		if(A == 0 && B == 0) {
        			break;
        		}
        	}
        	
        	
        	System.out.println(count);
        }

    }
 
    static int diff (int A, int B) {
        int count = 0;
        String arr1 = lights.get(A);
        String arr2 = lights.get(B);
        
        for(int i=0; i<arr1.length(); i++) {
        	if(arr1.charAt(i) != arr2.charAt(i)) {
        		count++;
        	}
        }
        
        return count;
    }
}