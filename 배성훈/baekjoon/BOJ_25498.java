import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
25498. 핸들 뭘로 하지 / 골드 2 / 1시간 26분
 */
public class BOJ_25498 {
    static int n;
    static String s;
    static List<Integer>[] adj;

    private static StringBuilder play() {
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new ArrayList<>();
        boolean[] visited=new boolean[n+1];
        arr.add(1);
        visited[1] = true;
        sb.append(s.charAt(0));
        while (!arr.isEmpty()) {
            List<Integer> validNodes = null;
            char max = '\0';
            for (int cur:arr) {
                for (int next:adj[cur]) {
                    if (visited[next]) continue;
                    char charOfNext=s.charAt(next-1);
                    if (max>charOfNext) continue;
                    if (validNodes==null||max<s.charAt(next-1)) {
                        validNodes=new ArrayList();
                        max=s.charAt(next-1);
                    }
                    validNodes.add(next);
                }
            }
            if (validNodes==null) break;

            sb.append(max);
            List<Integer> temp = new ArrayList<>();
            for (int next:validNodes) {
                visited[next]=true;
                temp.add(next);
            }
            arr=temp;
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        s=br.readLine();
        adj=new List[n + 1];
        for (int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for (int i=1;i<n;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        System.out.println(play());
    }
}