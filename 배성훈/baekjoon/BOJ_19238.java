import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
19238. 스타트 택시 / 골드 2 / 1시간 8분
 */
class BOJ_19238 {
    static final int[] dy={-1,1,0,0};
    static final int[] dx={0,0,-1,1};
    static int n,m,fuel;
    static int[][] arr;
    static Taxi t;
    static List<Passenger> plist;

    static class Passenger{
        int y,x,ty,tx;

        Passenger(int y,int x,int ty,int tx){
            this.y=y;
            this.x=x;
            this.ty=ty;
            this.tx=tx;
        }
    }

    static class Taxi{
        int y,x;

        Taxi(int y,int x){
            this.y=y;
            this.x=x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        fuel=Integer.parseInt(st.nextToken());
        arr=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        t=new Taxi(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        plist=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int ty=Integer.parseInt(st.nextToken());
            int tx=Integer.parseInt(st.nextToken());
            plist.add(new Passenger(y,x,ty,tx));
        }
        /*
        1. 최단거리 승객 태우기 (여러명이면 가장 왼쪽위에있는 애로)
        2. 연료는 한칸에 1씩 소모
        4. 데려다주면 소모연료*2 가 충전됨
        5. 이동도중에 연료가떨어지면 끝나는거임(-1 출력)

        승객 리스트
         */
        while(!plist.isEmpty()){
            // 최단거리승객고르기
            int idx=0;
            int minDist=Integer.MAX_VALUE;
            Passenger minp=new Passenger(n,n,n,n);
            for(int i=0;i<plist.size();i++){
                Passenger p=plist.get(i);
                int dist=bfs(t.y,t.x,p.y,p.x);
                if(dist==-1){
                    System.out.println(-1);
                    return;
                }
                if(minDist>dist){
                    minDist=dist;
                    minp=p;
                    idx=i;
                }else if(minDist==dist&&(minp.y>p.y||(minp.y==p.y&&minp.x>p.x))){
                    minp=p;
                    idx=i;
                }
            }
            plist.remove(idx);
            fuel-=minDist;
            if(fuel<=0){
                System.out.println(-1);
                return;
            }
            minDist=bfs(minp.y,minp.x,minp.ty,minp.tx);
            fuel-=minDist;
            if(fuel<0||minDist==-1){
                System.out.println(-1);
                return;
            }
            fuel+=(minDist*2);
            t.y=minp.ty;
            t.x=minp.tx;
        }
        System.out.println(fuel);
    }

    private static int bfs(int y,int x,int ty,int tx){
        boolean[][] visited=new boolean[n+1][n+1];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{y,x,0});
        visited[y][x]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            y=cur[0];
            x=cur[1];
            int dist=cur[2];
            if(y==ty&&x==tx){
                return dist;
            }
            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<1||nx<1||ny>n||nx>n||visited[ny][nx]||arr[ny][nx]==1)continue;
                q.add(new int[]{ny,nx,dist+1});
                visited[ny][nx]=true;
            }
        }
        return -1;
    }
}