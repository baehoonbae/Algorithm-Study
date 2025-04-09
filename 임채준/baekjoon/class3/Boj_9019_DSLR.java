package class3;

import java.io.*;
import java.util.*;

public class Boj_9019_DSLR {

    static int T, A, B;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            System.out.println(bfs(A, B));
        }
    }

    public static String bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] commands = new String[10000];

        queue.offer(start);
        visited[start] = true;
        commands[start] = "";

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == target) {
                return commands[cur];
            }

            int next = (cur * 2) % 10000;
            if(!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                commands[next] = commands[cur] + "D";
            }

            next = (cur == 0) ? 9999 : cur - 1;
            if(!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                commands[next] = commands[cur] + "S";
            }

            next = (cur % 1000) * 10 + cur / 1000;
            if(!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                commands[next] = commands[cur] + "L";
            }

            next = (cur % 10) * 1000 + cur / 10;
            if(!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                commands[next] = commands[cur] + "R";
            }
        }

        return "";
    }
}