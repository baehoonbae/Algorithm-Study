package src.sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_스마트물류 {

    static int N, K, ans;
    static char[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = br.readLine().toCharArray();
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(map[i] == 'P') visited[i] = true;
        }

        for(int i = 0; i < N; i++){
            for(int k = -1 * K; k <= K; k++){
                if(i + k < 0 || i + k >= N) continue;
                if(map[i] == 'P'){
                    if(map[i + k] == 'H' && !visited[i + k]){
                        ans++;
                        visited[i + k] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
