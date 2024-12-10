import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1966_프린터큐 {
    static int T;
    static class Document {
        int index, importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Document> que = new LinkedList<>();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int importance = Integer.parseInt(st.nextToken());
                que.offer(new Document(i, importance));
            }

            int count = 0; // 인쇄된 문서의 수
            while(!que.isEmpty()) {
                Document dd = que.poll();
                boolean flag = false;

                // 현재 문서보다 중요도 높은게 있는지 확인
                for(Document d : que) {
                    if(d.importance > dd.importance) {
                        flag = true;
                        break;
                    }
                }

                // 더 높은 중요도가 있으면 뒤로 보내기
                if(flag) {
                    que.offer(dd);
                } else {
                    count++;    // 현재 문서 인쇄
                    if(dd.index == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
