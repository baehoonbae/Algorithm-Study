package class3;

import java.io.*;
import java.util.*;

public class Boj_7662_이중우선순위큐 {

    static int T, k, n;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	
            k = Integer.parseInt(br.readLine().trim());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                n = Integer.parseInt(st.nextToken());
                
                if(command == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if(map.isEmpty()) continue;
                    int key = (n == 1) ? map.lastKey() : map.firstKey();
                    int count = map.get(key);
                    if(count == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, count - 1);
                    }
                }
            }

            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}