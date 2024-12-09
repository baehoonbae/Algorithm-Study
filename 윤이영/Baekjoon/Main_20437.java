import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_20437 {
	static int K, T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {			
			char[] W = br.readLine().toCharArray();
			K = Integer.parseInt(br.readLine());
			
			Map<Character, List<Integer>> map = new HashMap<>();
			// 각 문자의 인덱스를 기록
			for(int i=0; i<W.length; i++) {
				// 만약 해당 문자가 map에 없는 경우에는 새로 리스트를 만든다.
				if(!map.containsKey(W[i])) {
					map.put(W[i], new ArrayList<>());
				}
				// 이미 해당 문자가 map에 있다면, list에 index를 추가함
				map.get(W[i]).add(i);
			}
			
			int minL = Integer.MAX_VALUE;
			int maxL = -1;
			// map을 돌면서 문자열의 길이를 구하기
			for(char c: map.keySet()) {
				List<Integer> list = map.get(c);
				if(list.size() < K) continue; // K번 이상 등장하지 않은 문자는 패스
				
				// 길이를 구하기(리스트 인덱스 주의)
				for(int i=0; i<=list.size()-K; i++) {
					int l = list.get(i+K-1) - list.get(i)+1;
					minL = Math.min(minL, l);
					maxL = Math.max(maxL, l);
				}
			}
			// 결과 출력
			if(maxL == -1) {
				System.out.println(maxL);
			}else {
				System.out.println(minL+" "+maxL);
			}
			
		}
	}
}
