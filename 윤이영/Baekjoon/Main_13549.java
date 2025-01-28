import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_13549 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int mintime;

    static class Node implements Comparable<Node> {
        int pos, time;
        public Node (int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.time, o.time);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        find(N);

        System.out.println(mintime);
    }

    static void find(int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(n, 0));


        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int p = cur.pos;
            int t = cur.time;
            visited[p] = true;
            if(p == K){
                mintime = t;
                return;
            }
            if(p+1 <= 100000 && !visited[p+1]){
                pq.add(new Node(p+1, t+1));
            }
            if(p-1 >= 0 && !visited[p-1]){
                pq.add(new Node(p-1, t+1));
            }
            if(p*2 <= 100000 && !visited[p*2]){
                pq.add(new Node(p*2, t));
            }
        }

    }
}
