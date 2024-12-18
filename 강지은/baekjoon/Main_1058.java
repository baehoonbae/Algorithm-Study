import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1058 {
    
	static int N;
	static ArrayList<Integer>[] adj;
	static int[] friends;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	
    	N = Integer.parseInt(br.readLine());
    	
    	friends = new int[N];
    	adj = new ArrayList[N];
    	for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] str = st.nextToken().toCharArray();
			for (int j = 0; j < N; j++) {
				if (i==j) continue;
				if (str[j] == 'Y') {
					adj[i].add(j);
				}
			}
		}
        
    	int max = 0;
    	for (int i = 0; i < N; i++) {
			friends[i] = count(i);
			max = Math.max(max, friends[i]);
		}
    	
    	System.out.println(max);
    	
    }

	private static int count(int idx) {
		int size = adj[idx].size();
		List<Integer> twos = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			int friend = adj[idx].get(i);
			
			for (int j = 0; j < adj[friend].size(); j++) {
				int two = adj[friend].get(j);
				
				if (idx==two) continue;
				if (!adj[idx].contains(two) && !twos.contains(two)) {
					twos.add(two);
				}
			}
		}
		
		return size+twos.size();
	}
    
}
